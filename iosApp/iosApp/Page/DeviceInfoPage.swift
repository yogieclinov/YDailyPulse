import SwiftUI

struct DeviceInfoPage: View {
    var body: some View {
        NavigationStack {
            DeviceInfoListView()
                .navigationTitle("About Device")
        }
    }
}

#Preview {
    DeviceInfoPage()
}
