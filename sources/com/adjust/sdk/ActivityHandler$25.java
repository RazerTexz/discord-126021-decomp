package com.adjust.sdk;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ActivityHandler$25 implements Runnable {
    public final /* synthetic */ ActivityHandler this$0;
    public final /* synthetic */ JSONObject val$adRevenueJson;
    public final /* synthetic */ String val$source;

    public ActivityHandler$25(ActivityHandler activityHandler, String str, JSONObject jSONObject) {
        this.this$0 = activityHandler;
        this.val$source = str;
        this.val$adRevenueJson = jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActivityHandler.access$2500(this.this$0, this.val$source, this.val$adRevenueJson);
    }
}
