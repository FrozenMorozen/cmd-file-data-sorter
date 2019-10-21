package com.company;

import com.company.service.AppLauncherService;
import com.company.service.impl.AppLauncherServiceImpl;

public class Main {

    public static void main(String[] args) {
        AppLauncherService appLauncherService = new AppLauncherServiceImpl();
        appLauncherService.launch(args);
    }

}




