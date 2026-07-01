package com.discord.restapi;

import i0.f0.f;
import i0.f0.y;
import okhttp3.ResponseBody;
import rx.Observable;

/* JADX INFO: compiled from: RestAPIInterface.kt */
/* JADX INFO: loaded from: classes.dex */
public interface RestAPIInterface$Files {
    @f
    Observable<ResponseBody> getFile(@y String url);
}
