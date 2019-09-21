package com.company;

import com.company.service.AppLauncherService;
import com.company.service.impl.AppLauncherServiceImpl;

public class Main {

//    @Inject
//    private AppLauncherService appLauncher;

    public static void main(String[] args) {
        AppLauncherService appLauncherService = new AppLauncherServiceImpl();
        appLauncherService.launch(args);
    }

}




