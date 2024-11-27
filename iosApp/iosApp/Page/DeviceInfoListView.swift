import shared
import SwiftUI

struct DeviceInfoListView: View {
    
    private struct RowItem: Hashable {
        let title: String
        let subtitle: String
    }
    
    private let items: [RowItem] = {
        let platform = Platform_iosKt.getPlatform()
        
        var result: [RowItem] = [
            .init(
                title: "Operating System",
                subtitle: "\(platform.osName)"
            ),
            .init(
                title: "Device",
                subtitle: "\(platform.deviceModel) \(platform.osVersion)"
            ),
            .init(
                title: "Density",
                subtitle: "\(platform.density)"
            )
        ]
        return result
    }()
    
    var body: some View {
        List {
            ForEach(items, id: \.self) { item in
                VStack(alignment: .leading) {
                    Text(item.title)
                        .font(.footnote)
                    Text(item.subtitle)
                        .font(.footnote)
                }
                .padding(.vertical, 4)
            }
        }
    }
}

#Preview {
    DeviceInfoListView()
}
