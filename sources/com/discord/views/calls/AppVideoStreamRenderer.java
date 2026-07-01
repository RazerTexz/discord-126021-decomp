package com.discord.views.calls;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.MainThread;
import b.a.y.j0.AppVideoStreamRenderer2;
import b.a.y.j0.AppVideoStreamRenderer3;
import b.a.y.j0.AppVideoStreamRenderer4;
import b.a.y.j0.AppVideoStreamRenderer5;
import b.a.y.j0.RxRendererEvents;
import b.d.b.a.outline;
import co.discord.media_engine.VideoStreamRenderer;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.TypeIntrinsics;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.webrtc.RendererCommon;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

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
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        this.onSizeChangedSubject = BehaviorSubject.l0(Unit.a);
        this.currentFrameResolutionSubject = BehaviorSubject.l0(null);
        RendererCommon.ScalingType scalingType = RendererCommon.ScalingType.SCALE_ASPECT_BALANCED;
        this.prevScalingType = scalingType;
        this.prevScalingTypeMismatchOrientation = scalingType;
    }

    @MainThread
    public final void b() {
        Subscription subscription = this.updateRendererSizeSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        HashMap<Integer, VideoStreamRenderer> map = AppVideoStreamRenderer5.a;
        Integer num = this.streamId;
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        TypeIntrinsics.asMutableMap(map).remove(num);
        this.currentFrameResolutionSubject.onNext(null);
        map.isEmpty();
        VideoStreamRenderer.attachToStream$default(this, StoreStream.INSTANCE.getMediaEngine().getVoiceEngineNative(), null, null, 4, null);
    }

    @MainThread
    public final void c(Integer newStreamId, RendererCommon.ScalingType scalingType, RendererCommon.ScalingType scalingTypeMismatchOrientation, boolean isVideoMirrored) {
        if (newStreamId == null) {
            b();
            this.streamId = null;
            return;
        }
        boolean z2 = !Intrinsics3.areEqual(newStreamId, this.streamId);
        if (z2) {
            b();
        }
        if (z2) {
            int iIntValue = newStreamId.intValue();
            HashMap<Integer, VideoStreamRenderer> map = AppVideoStreamRenderer5.a;
            VideoStreamRenderer videoStreamRenderer = map.get(Integer.valueOf(iIntValue));
            if (videoStreamRenderer != null && videoStreamRenderer != this) {
                VideoStreamRenderer.attachToStream$default(videoStreamRenderer, StoreStream.INSTANCE.getMediaEngine().getVoiceEngineNative(), null, null, 4, null);
                map.remove(Integer.valueOf(iIntValue));
                map.isEmpty();
            }
            map.put(Integer.valueOf(iIntValue), this);
            RxRendererEvents rxRendererEvents = new RxRendererEvents();
            Subscription subscription = this.updateRendererSizeSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            Observable<R> observableA = this.onSizeChangedSubject.A(new AppVideoStreamRenderer2(rxRendererEvents));
            Intrinsics3.checkNotNullExpressionValue(observableA, "onSizeChangedSubject\n   …rameResolutionSampled() }");
            Observable observableG = observableA.y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            Observable observableUi = ObservableExtensionsKt.ui(observableG);
            AppVideoStreamRenderer3 appVideoStreamRenderer3 = new AppVideoStreamRenderer3(this);
            String simpleName = AppVideoStreamRenderer.class.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            ObservableExtensionsKt.appSubscribe(observableUi, (117 & 1) != 0 ? null : null, simpleName, (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : new AppVideoStreamRenderer4(this)), appVideoStreamRenderer3, (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
            StringBuilder sbU = outline.U("binding native renderer ");
            sbU.append(hashCode());
            sbU.append(" to stream id: ");
            sbU.append(iIntValue);
            Log.d("AppVideoStreamRenderer", sbU.toString());
            attachToStream(StoreStream.INSTANCE.getMediaEngine().getVoiceEngineNative(), String.valueOf(iIntValue), rxRendererEvents);
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
        this.onSizeChangedSubject.onNext(Unit.a);
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
