import SwiftUI
import shared


extension ArticlesPage {
    
    @MainActor
    class ArticlesPresenterWrapper: ObservableObject {
        let articlesPresenter: ArticlesPresenter
        
        init() {
            articlesPresenter = ArticlesInjector().articlesPresenter
            articlesState = articlesPresenter.articlesState.value
        }
        
        @Published var articlesState: ArticlesState
        
        func startObserve() {
            Task {
                for await articlesS in articlesPresenter.articlesState {
                    self.articlesState = articlesS
                }
            }
        }
    }
}

struct ArticlesPage: View {
    
    @ObservedObject private(set) var presenter: ArticlesPresenterWrapper
    
    var body: some View {
        VStack {
            AppBar()
            if presenter.articlesState.isLoading {
                Loader()
            }
            if let error = presenter.articlesState.error {
                ErrorText(message: error.description)
            }
            if (!presenter.articlesState.articles.isEmpty) {
                ArticlesList(articles: presenter.articlesState.uiModels)
            }
        }.onAppear {
            self.presenter.startObserve()
        }
    }
}

//#Preview {
//    ArticlesPage()
//}

struct AppBar: View {
    var body: some View {
        Text("Articles")
            .font(.largeTitle)
            .fontWeight(.bold)
    }
}

struct ArticlesList: View {
    var articles: [ArticleUiItem]
    
    var body: some View {
        ScrollView {
            LazyVStack(spacing: 10) {
                ForEach(articles, id: \.self) { article in
                    ArticleItem(article: article)
                }
            }
        }
    }
}

struct ArticleItem: View {
    var article: ArticleUiItem
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            AsyncImage(url: URL(string: article.imageUrl)) { phase in
                if phase.image != nil {
                    phase.image!.resizable().aspectRatio(contentMode: .fit)
                } else if phase.error != nil {
                    Text("Image Load Error")
                } else {
                    ProgressView()
                }
            }.clipShape(RoundedRectangle(cornerRadius: 8.0))
            Text(article.title)
            Text(article.desc)
            Text(article.date)
                .frame(maxWidth: .infinity, alignment: .trailing)
                .foregroundStyle(.gray)
        }.padding(16)
    }
}
