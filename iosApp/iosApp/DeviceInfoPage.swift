//
//  DeviceInfoPage.swift
//  iosApp
//
//  Created by Yogie Clinov Tanjung on 28/10/24.
//  Copyright © 2024 orgName. All rights reserved.
//

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
