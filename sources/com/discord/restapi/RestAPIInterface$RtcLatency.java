package com.discord.restapi;

import com.discord.models.domain.ModelRtcLatencyRegion;
import i0.f0.f;
import i0.f0.y;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: RestAPIInterface.kt */
/* JADX INFO: loaded from: classes.dex */
public interface RestAPIInterface$RtcLatency {
    @f
    Observable<List<ModelRtcLatencyRegion>> get(@y String url);
}
