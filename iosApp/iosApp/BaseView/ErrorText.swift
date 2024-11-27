import SwiftUI

struct ErrorText: View {
    var message: String
    
    var body: some View {
        Text(message).font(.title)
    }
}

#Preview {
    ErrorText(message: "Something broken. Please wait...")
}
