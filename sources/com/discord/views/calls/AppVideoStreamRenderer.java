package com.discord.views.calls;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.MainThread;
import b.a.y.j0.a;
import b.a.y.j0.b;
import b.a.y.j0.c;
import b.a.y.j0.d;
import b.a.y.j0.e;
import co.discord.media_engine.VideoStreamRenderer;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import d0.z.d.e0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.webrtc.RendererCommon$ScalingType;
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
    public RendererCommon$ScalingType prevScalingType;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public RendererCommon$ScalingType prevScalingTypeMismatchOrientation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppVideoStreamRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        this.onSizeChangedSubject = BehaviorSubject.l0(Unit.a);
        this.currentFrameResolutionSubject = BehaviorSubject.l0(null);
        RendererCommon$ScalingType rendererCommon$ScalingType = RendererCommon$ScalingType.SCALE_ASPECT_BALANCED;
        this.prevScalingType = rendererCommon$ScalingType;
        this.prevScalingTypeMismatchOrientation = rendererCommon$ScalingType;
    }

    @MainThread
    public final void b() {
        Subscription subscription = this.updateRendererSizeSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        HashMap<Integer, VideoStreamRenderer> map = d.a;
        Integer num = this.streamId;
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        e0.asMutableMap(map).remove(num);
        this.currentFrameResolutionSubject.onNext(null);
        map.isEmpty();
        VideoStreamRenderer.attachToStream$default(this, StoreStream.Companion.getMediaEngine().getVoiceEngineNative(), null, null, 4, null);
    }

    @MainThread
    public final void c(Integer newStreamId, RendererCommon$ScalingType scalingType, RendererCommon$ScalingType scalingTypeMismatchOrientation, boolean isVideoMirrored) {
        if (newStreamId == null) {
            b();
            this.streamId = null;
            return;
        }
        boolean z2 = !m.areEqual(newStreamId, this.streamId);
        if (z2) {
            b();
        }
        if (z2) {
            int iIntValue = newStreamId.intValue();
            HashMap<Integer, VideoStreamRenderer> map = d.a;
            VideoStreamRenderer videoStreamRenderer = map.get(Integer.valueOf(iIntValue));
            if (videoStreamRenderer != null && videoStreamRenderer != this) {
                VideoStreamRenderer.attachToStream$default(videoStreamRenderer, StoreStream.Companion.getMediaEngine().getVoiceEngineNative(), null, null, 4, null);
                map.remove(Integer.valueOf(iIntValue));
                map.isEmpty();
            }
            map.put(Integer.valueOf(iIntValue), this);
            e eVar = new e();
            Subscription subscription = this.updateRendererSizeSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            Observable<R> observableA = this.onSizeChangedSubject.A(new a(eVar));
            m.checkNotNullExpressionValue(observableA, "onSizeChangedSubject\n   …rameResolutionSampled() }");
            Observable observableG = observableA.y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
            m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            Observable observableUi = ObservableExtensionsKt.ui(observableG);
            b bVar = new b(this);
            String simpleName = AppVideoStreamRenderer.class.getSimpleName();
            m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            ObservableExtensionsKt.appSubscribe$default(observableUi, (Context) null, simpleName, new c(this), bVar, (Function1) null, (Function0) null, (Function0) null, 113, (Object) null);
            StringBuilder sbU = b.d.b.a.a.U("binding native renderer ");
            sbU.append(hashCode());
            sbU.append(" to stream id: ");
            sbU.append(iIntValue);
            Log.d("AppVideoStreamRenderer", sbU.toString());
            attachToStream(StoreStream.Companion.getMediaEngine().getVoiceEngineNative(), String.valueOf(iIntValue), eVar);
            this.streamId = newStreamId;
        }
        RendererCommon$ScalingType rendererCommon$ScalingType = scalingType != null ? scalingType : this.prevScalingType;
        RendererCommon$ScalingType rendererCommon$ScalingType2 = scalingTypeMismatchOrientation != null ? scalingTypeMismatchOrientation : this.prevScalingTypeMismatchOrientation;
        setMirror(isVideoMirrored);
        setZOrderMediaOverlay(this.isOverlay);
        if (rendererCommon$ScalingType == this.prevScalingType && rendererCommon$ScalingType2 == this.prevScalingTypeMismatchOrientation) {
            return;
        }
        setScalingType(rendererCommon$ScalingType, rendererCommon$ScalingType2);
        this.prevScalingType = rendererCommon$ScalingType;
        this.prevScalingTypeMismatchOrientation = rendererCommon$ScalingType2;
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
