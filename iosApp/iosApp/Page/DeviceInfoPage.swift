import SwiftUI

struct DeviceInfoPage: View {
    
    @Environment(\.dismiss)
    private var dismiss
    
    var body: some View {
        NavigationStack {
            DeviceInfoListView()
                .navigationTitle("About Device")
                .toolbar {
                    ToolbarItem {
                        Button {
                            dismiss()
                        } label: {
                            Text("Close")
                        }
                    }
                }
        }
    }
}

#Preview {
    DeviceInfoPage()
}
