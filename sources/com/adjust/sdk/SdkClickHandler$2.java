package com.adjust.sdk;

import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class SdkClickHandler$2 implements Runnable {
    public final /* synthetic */ SdkClickHandler this$0;

    public SdkClickHandler$2(SdkClickHandler sdkClickHandler) {
        this.this$0 = sdkClickHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        IActivityHandler iActivityHandler = (IActivityHandler) SdkClickHandler.access$300(this.this$0).get();
        SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(iActivityHandler.getContext());
        try {
            JSONArray rawReferrerArray = sharedPreferencesManager.getRawReferrerArray();
            boolean z2 = false;
            for (int i = 0; i < rawReferrerArray.length(); i++) {
                JSONArray jSONArray = rawReferrerArray.getJSONArray(i);
                if (jSONArray.optInt(2, -1) == 0) {
                    String strOptString = jSONArray.optString(0, null);
                    long jOptLong = jSONArray.optLong(1, -1L);
                    jSONArray.put(2, 1);
                    this.this$0.sendSdkClick(PackageFactory.buildReftagSdkClickPackage(strOptString, jOptLong, iActivityHandler.getActivityState(), iActivityHandler.getAdjustConfig(), iActivityHandler.getDeviceInfo(), iActivityHandler.getSessionParameters()));
                    z2 = true;
                }
            }
            if (z2) {
                sharedPreferencesManager.saveRawReferrerArray(rawReferrerArray);
            }
        } catch (JSONException e) {
            SdkClickHandler.access$100(this.this$0).error("Send saved raw referrers error (%s)", e.getMessage());
        }
    }
}
