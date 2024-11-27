import SwiftUI
import shared

struct ContentView: View {
    
    @Environment(\.dismiss)
    private var dismiss
    
    @State private var shouldOpenDeviceInfo = false

	var body: some View {
        NavigationStack {
            ArticlesPage(presenter: .init())
                .toolbar {
                    ToolbarItem {
                        Button {
                            shouldOpenDeviceInfo = true
                        } label: {
                            Label("Device Info", systemImage: "info.circle").labelStyle(TitleAndIconLabelStyle())
                        }
                        .popover(isPresented: $shouldOpenDeviceInfo, content: {
                            DeviceInfoPage()
                        })
                    }
                }
        }
        
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
