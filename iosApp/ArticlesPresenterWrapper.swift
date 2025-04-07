import SwiftUI
import shared

extension ArticlesPage {
    
    @MainActor
    class ArticlesPresenterWrapper: ObservableObject {
        let articlesPresenter: ArticlesPresenter
        
        init() {
            articlesPresenter = ArticlesPresenter()
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