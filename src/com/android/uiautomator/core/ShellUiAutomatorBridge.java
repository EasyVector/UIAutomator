/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.uiautomator.core;


import android.app.UiAutomation;

import android.view.Display;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @hide
 */
public class ShellUiAutomatorBridge extends UiAutomatorBridge {

    private static final String LOG_TAG = ShellUiAutomatorBridge.class.getSimpleName();

    public ShellUiAutomatorBridge(UiAutomation uiAutomation) {
        super(uiAutomation);
    }

    public Display getDefaultDisplay() {
        try {
            Class DisplayManagerGlobal = Class.forName("android.hardware.display.DisplayManagerGlobal");
            Method getInstanceMethod = DisplayManagerGlobal.getMethod("getInstance", int.class);
            Method getRealDisplay = DisplayManagerGlobal.getMethod("getRealDisplay", int.class);
            Object instanceResult = getInstanceMethod.invoke(null, (Object) null);
            return (Display) getRealDisplay.invoke(instanceResult, Display.DEFAULT_DISPLAY);
//            return Global.getInstance().getRealDisplay(Display.DEFAULT_DISPLAY);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public long getSystemLongPressTime() {
        // Read the long press timeout setting.
        long longPressTimeout = 0;
//        try {
//            IContentProvider provider = null;
//            Cursor cursor = null;
//            IActivityManager activityManager = ActivityManagerNative.getDefault();
//            String providerName = Settings.Secure.CONTENT_URI.getAuthority();
//            IBinder token = new Binder();
//            try {
//                ContentProviderHolder holder = activityManager.getContentProviderExternal(
//                        providerName, UserHandle.USER_OWNER, token);
//                if (holder == null) {
//                    throw new IllegalStateException("Could not find provider: " + providerName);
//                }
//                provider = holder.provider;
//                cursor = provider.query(null, Settings.Secure.CONTENT_URI,
//                        new String[] {
//                            Settings.Secure.VALUE
//                        }, "name=?",
//                        new String[] {
//                            Settings.Secure.LONG_PRESS_TIMEOUT
//                        }, null, null);
//                if (cursor.moveToFirst()) {
//                    longPressTimeout = cursor.getInt(0);
//                }
//            } finally {
//                if (cursor != null) {
//                    cursor.close();
//                }
//                if (provider != null) {
//                    activityManager.removeContentProviderExternal(providerName, token);
//                }
//            }
//        } catch (RemoteException e) {
//            String message = "Error reading long press timeout setting.";
//            Log.e(LOG_TAG, message, e);
//            throw new RuntimeException(message, e);
//        }
        return longPressTimeout;
    }

    @Override
    public int getRotation() {
//        IWindowManager wm =
//                IWindowManager.Stub.asInterface(ServiceManager.getService(Context.WINDOW_SERVICE));
        int ret = -1;
//        try {
//            ret = wm.getRotation();
//        } catch (RemoteException e) {
//            Log.e(LOG_TAG, "Error getting screen rotation", e);
//            throw new RuntimeException(e);
//        }
        return ret;
    }

    @Override
    public boolean isScreenOn() {
//        IPowerManager pm =
//                IPowerManager.Stub.asInterface(ServiceManager.getService(Context.POWER_SERVICE));
        boolean ret = false;
//        try {
//            ret = pm.isInteractive();
//        } catch (RemoteException e) {
//            Log.e(LOG_TAG, "Error getting screen status", e);
//            throw new RuntimeException(e);
//        }
        return ret;
    }
}
