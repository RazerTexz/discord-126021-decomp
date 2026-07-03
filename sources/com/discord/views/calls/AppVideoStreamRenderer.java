package com.discord.views.calls;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.MainThread;
import co.discord.media_engine.VideoStreamRenderer;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.webrtc.RendererCommon;
import p007b.p008a.p062y.p063j0.C1338a;
import p007b.p008a.p062y.p063j0.C1339b;
import p007b.p008a.p062y.p063j0.C1340c;
import p007b.p008a.p062y.p063j0.C1341d;
import p007b.p008a.p062y.p063j0.C1342e;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12224e0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: AppVideoStreamRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppVideoStreamRenderer extends VideoStreamRenderer {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public boolean isOverlay;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final BehaviorSubject<Unit> onSizeChangedSubject;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Subscription updateRendererSizeSubscription;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Integer streamId;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public BehaviorSubject<Point> currentFrameResolutionSubject;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public Function1<? super Point, Unit> onFrameRenderedListener;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public RendererCommon.ScalingType prevScalingType;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public RendererCommon.ScalingType prevScalingTypeMismatchOrientation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppVideoStreamRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
        this.onSizeChangedSubject = BehaviorSubject.m11130l0(Unit.f27425a);
        this.currentFrameResolutionSubject = BehaviorSubject.m11130l0(null);
        RendererCommon.ScalingType scalingType = RendererCommon.ScalingType.SCALE_ASPECT_BALANCED;
        this.prevScalingType = scalingType;
        this.prevScalingTypeMismatchOrientation = scalingType;
    }

    @MainThread
    /* JADX INFO: renamed from: b */
    public final void m8571b() {
        Subscription subscription = this.updateRendererSizeSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        HashMap<Integer, VideoStreamRenderer> map = C1341d.f2029a;
        Integer num = this.streamId;
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        C12224e0.asMutableMap(map).remove(num);
        this.currentFrameResolutionSubject.onNext(null);
        map.isEmpty();
        VideoStreamRenderer.attachToStream$default(this, StoreStream.INSTANCE.getMediaEngine().getVoiceEngineNative(), null, null, 4, null);
    }

    @MainThread
    /* JADX INFO: renamed from: c */
    public final void m8572c(Integer newStreamId, RendererCommon.ScalingType scalingType, RendererCommon.ScalingType scalingTypeMismatchOrientation, boolean isVideoMirrored) {
        if (newStreamId == null) {
            m8571b();
            this.streamId = null;
            return;
        }
        boolean z2 = !C12238m.areEqual(newStreamId, this.streamId);
        if (z2) {
            m8571b();
        }
        if (z2) {
            int iIntValue = newStreamId.intValue();
            HashMap<Integer, VideoStreamRenderer> map = C1341d.f2029a;
            VideoStreamRenderer videoStreamRenderer = map.get(Integer.valueOf(iIntValue));
            if (videoStreamRenderer != null && videoStreamRenderer != this) {
                VideoStreamRenderer.attachToStream$default(videoStreamRenderer, StoreStream.INSTANCE.getMediaEngine().getVoiceEngineNative(), null, null, 4, null);
                map.remove(Integer.valueOf(iIntValue));
                map.isEmpty();
            }
            map.put(Integer.valueOf(iIntValue), this);
            C1342e c1342e = new C1342e();
            Subscription subscription = this.updateRendererSizeSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            Observable<R> observableM11082A = this.onSizeChangedSubject.m11082A(new C1338a(c1342e));
            C12238m.checkNotNullExpressionValue(observableM11082A, "onSizeChangedSubject\n   …rameResolutionSampled() }");
            Observable observableM11083G = observableM11082A.m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
            C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
            Observable observableM8518ui = ObservableExtensionsKt.m8518ui(observableM11083G);
            C1339b c1339b = new C1339b(this);
            String simpleName = AppVideoStreamRenderer.class.getSimpleName();
            C12238m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            ObservableExtensionsKt.appSubscribe(observableM8518ui, (117 & 1) != 0 ? null : null, simpleName, (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : new C1340c(this)), c1339b, (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
            StringBuilder sbM833U = C1643a.m833U("binding native renderer ");
            sbM833U.append(hashCode());
            sbM833U.append(" to stream id: ");
            sbM833U.append(iIntValue);
            Log.d("AppVideoStreamRenderer", sbM833U.toString());
            attachToStream(StoreStream.INSTANCE.getMediaEngine().getVoiceEngineNative(), String.valueOf(iIntValue), c1342e);
            this.streamId = newStreamId;
        }
        RendererCommon.ScalingType scalingType2 = scalingType != null ? scalingType : this.prevScalingType;
        RendererCommon.ScalingType scalingType3 = scalingTypeMismatchOrientation != null ? scalingTypeMismatchOrientation : this.prevScalingTypeMismatchOrientation;
        setMirror(isVideoMirrored);
        setZOrderMediaOverlay(this.isOverlay);
        if (scalingType2 == this.prevScalingType && scalingType3 == this.prevScalingTypeMismatchOrientation) {
            return;
        }
        setScalingType(scalingType2, scalingType3);
        this.prevScalingType = scalingType2;
        this.prevScalingTypeMismatchOrientation = scalingType3;
    }

    public final Function1<Point, Unit> getOnFrameRenderedListener() {
        return this.onFrameRenderedListener;
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.onSizeChangedSubject.onNext(Unit.f27425a);
        super.clearImage();
    }

    public final void setIsOverlay(boolean isOverlay) {
        this.isOverlay = isOverlay;
    }

    public final void setMatchVideoOrientation(boolean matchVideoOrientation) {
    }

    public final void setOnFrameRenderedListener(Function1<? super Point, Unit> function1) {
        this.onFrameRenderedListener = function1;
    }
}
