package com.discord.widgets.changelog;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.VideoView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import b.f.g.a.a.Fresco;
import b.f.g.a.a.PipelineDraweeControllerBuilder;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChangeLogBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.Tuples;
import d0.d0._Ranges;
import d0.g0.StringsJVM;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: compiled from: WidgetChangeLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLog extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChangeLog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChangeLogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_BODY = "INTENT_EXTRA_BODY";
    private static final String INTENT_EXTRA_REVISION = "INTENT_EXTRA_REVISION";
    private static final String INTENT_EXTRA_VERSION = "INTENT_EXTRA_VERSION";
    private static final String INTENT_EXTRA_VIDEO = "INTENT_EXTRA_VIDEO";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private int maxScrolledPercent;
    private long openedTimestamp;
    private final WidgetChangeLog4 thumbnailControllerListener;
    private AbstractDraweeController<Object, Object> thumbnailDraweeController;

    /* JADX INFO: compiled from: WidgetChangeLog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, String version, String revision, String video, String body) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(version, "version");
            Intrinsics3.checkNotNullParameter(revision, "revision");
            Intrinsics3.checkNotNullParameter(video, MediaStreamTrack.VIDEO_TRACK_KIND);
            Intrinsics3.checkNotNullParameter(body, "body");
            Bundle bundle = new Bundle();
            bundle.putString(WidgetChangeLog.INTENT_EXTRA_VERSION, version);
            bundle.putString(WidgetChangeLog.INTENT_EXTRA_REVISION, revision);
            bundle.putString(WidgetChangeLog.INTENT_EXTRA_VIDEO, video);
            bundle.putString(WidgetChangeLog.INTENT_EXTRA_BODY, body);
            AppScreen2.d(context, WidgetChangeLog.class, new Intent().putExtras(bundle));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.changelog.WidgetChangeLog$hideVideoOverlay$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChangeLog.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ViewPropertyAnimator, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            Intrinsics3.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(2.0f);
            viewPropertyAnimator.scaleY(2.0f);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.changelog.WidgetChangeLog$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChangeLog.kt */
    public static final class AnonymousClass1 extends Lambda implements Function3<Context, String, String, Unit> {
        public AnonymousClass1() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Context context, String str, String str2) {
            invoke2(context, str, str2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Context context, String str, String str2) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(str, "url");
            WidgetChangeLog.track$default(WidgetChangeLog.this, "change_log_cta_clicked", MapsJVM.mapOf(Tuples.to("cta_type", "inline_link")), false, 4, null);
            UriHandler.handle$default(UriHandler.INSTANCE, context, str, false, false, null, 28, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.changelog.WidgetChangeLog$showVideoOverlay$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChangeLog.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            view.setScaleX(2.0f);
            view.setScaleY(2.0f);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.changelog.WidgetChangeLog$showVideoOverlay$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChangeLog.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<ViewPropertyAnimator, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            Intrinsics3.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(1.0f);
            viewPropertyAnimator.scaleY(1.0f);
        }
    }

    public WidgetChangeLog() {
        super(R.layout.widget_change_log);
        this.binding = FragmentViewBindingDelegate3.viewBinding(this, WidgetChangeLog2.INSTANCE, new WidgetChangeLog3(this));
        this.thumbnailControllerListener = new WidgetChangeLog4(this);
    }

    private final void configureFooter() {
        getBinding().g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.changelog.WidgetChangeLog.configureFooter.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UriHandler.handle$default(UriHandler.INSTANCE, WidgetChangeLog.this.requireContext(), WidgetChangeLog.this.getString(R.string.twitter_page_url), false, false, null, 28, null);
            }
        });
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.changelog.WidgetChangeLog.configureFooter.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UriHandler.handle$default(UriHandler.INSTANCE, WidgetChangeLog.this.requireContext(), "https://www.facebook.com/discordapp", false, false, null, 28, null);
            }
        });
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.changelog.WidgetChangeLog.configureFooter.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UriHandler.handle$default(UriHandler.INSTANCE, WidgetChangeLog.this.requireContext(), "https://www.instagram.com/discord", false, false, null, 28, null);
            }
        });
    }

    private final void configureMedia(String videoUrl) {
        boolean zEndsWith$default = StringsJVM.endsWith$default(videoUrl, ".mp4", false, 2, null);
        VideoView videoView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
        videoView.setVisibility(zEndsWith$default ? 0 : 8);
        SimpleDraweeView simpleDraweeView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.changeLogVideoOverlay");
        simpleDraweeView.setVisibility(zEndsWith$default ? 0 : 8);
        if (zEndsWith$default) {
            getBinding().h.setVideoPath(videoUrl);
            getBinding().h.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.discord.widgets.changelog.WidgetChangeLog.configureMedia.1
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    WidgetChangeLog.this.showVideoOverlay();
                }
            });
            getBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.changelog.WidgetChangeLog.configureMedia.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoView videoView2 = WidgetChangeLog.this.getBinding().h;
                    Intrinsics3.checkNotNullExpressionValue(videoView2, "binding.changeLogVideo");
                    if (videoView2.isPlaying()) {
                        WidgetChangeLog.this.showVideoOverlay();
                        WidgetChangeLog.this.getBinding().h.pause();
                    } else {
                        WidgetChangeLog.this.hideVideoOverlay();
                        WidgetChangeLog.this.getBinding().h.start();
                    }
                    WidgetChangeLog.track$default(WidgetChangeLog.this, "change_log_video_interacted", null, false, 2, null);
                }
            });
            getBinding().h.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.discord.widgets.changelog.WidgetChangeLog.configureMedia.3
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer) {
                    Intrinsics3.checkNotNullParameter(mediaPlayer, "mp");
                    mediaPlayer.start();
                    mediaPlayer.pause();
                    VideoView videoView2 = WidgetChangeLog.this.getBinding().h;
                    Intrinsics3.checkNotNullExpressionValue(videoView2, "binding.changeLogVideo");
                    videoView2.getLayoutParams().height = -2;
                    WidgetChangeLog.this.getBinding().h.requestLayout();
                }
            });
            return;
        }
        SimpleDraweeView simpleDraweeView2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.changeLogThumbnail");
        simpleDraweeView2.setVisibility(0);
        PipelineDraweeControllerBuilder pipelineDraweeControllerBuilderA = Fresco.a();
        SimpleDraweeView simpleDraweeView3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.changeLogThumbnail");
        pipelineDraweeControllerBuilderA.n = simpleDraweeView3.getController();
        PipelineDraweeControllerBuilder pipelineDraweeControllerBuilderG = pipelineDraweeControllerBuilderA.g(videoUrl);
        pipelineDraweeControllerBuilderG.m = false;
        pipelineDraweeControllerBuilderG.k = this.thumbnailControllerListener;
        this.thumbnailDraweeController = pipelineDraweeControllerBuilderG.a();
        SimpleDraweeView simpleDraweeView4 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.changeLogThumbnail");
        simpleDraweeView4.setController(this.thumbnailDraweeController);
        getBinding().f.requestLayout();
    }

    private final WidgetChangeLogBinding getBinding() {
        return (WidgetChangeLogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CharSequence getDateString(Context context) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_VERSION);
        if (stringExtra == null) {
            stringExtra = getString(R.string.change_log_md_date);
        }
        Intrinsics3.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…tring.change_log_md_date)");
        try {
            Date date = new SimpleDateFormat(TimeUtils.UTCFormat.SHORT).parse(stringExtra);
            if (date == null) {
                date = new Date();
            }
            String str = DateFormat.getMediumDateFormat(context).format(date);
            Intrinsics3.checkNotNullExpressionValue(str, "DateFormat.getMediumDate…mat(context).format(date)");
            return str;
        } catch (ParseException unused) {
            return stringExtra;
        }
    }

    private final void hideVideoOverlay() {
        ViewExtensions.fadeOut$default(getBinding().i, 200L, AnonymousClass1.INSTANCE, null, 4, null);
    }

    public static final void launch(Context context, String str, String str2, String str3, String str4) {
        INSTANCE.launch(context, str, str2, str3, str4);
    }

    private final void onViewBindingDestroy(WidgetChangeLogBinding binding) {
        binding.h.setOnPreparedListener(null);
        binding.h.setOnCompletionListener(null);
        AbstractDraweeController<Object, Object> abstractDraweeController = this.thumbnailDraweeController;
        if (abstractDraweeController != null) {
            abstractDraweeController.A(this.thumbnailControllerListener);
        }
    }

    private final void showVideoOverlay() {
        ViewExtensions.fadeIn$default(getBinding().i, 200L, AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE, null, 8, null);
    }

    private final void track(String event, Map<String, ? extends Object> properties, boolean includeStats) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_VERSION);
        if (stringExtra == null) {
            stringExtra = getString(R.string.change_log_md_date);
        }
        Intrinsics3.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…tring.change_log_md_date)");
        String stringExtra2 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_REVISION);
        if (stringExtra2 == null) {
            stringExtra2 = getString(R.string.change_log_md_revision);
        }
        Intrinsics3.checkNotNullExpressionValue(stringExtra2, "mostRecentIntent.getStri…g.change_log_md_revision)");
        HashMap map = new HashMap();
        if (includeStats) {
            map.put("seconds_open", Long.valueOf((ClockFactory.get().currentTimeMillis() - this.openedTimestamp) / ((long) 1000)));
            map.put("max_scrolled_percentage", Integer.valueOf(this.maxScrolledPercent));
        }
        AnalyticsTracker.INSTANCE.changeLogEvent(event, stringExtra, stringExtra2, Maps6.plus(properties, map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void track$default(WidgetChangeLog widgetChangeLog, String str, Map map, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            map = new HashMap();
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        widgetChangeLog.track(str, map, z2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_VERSION);
        if (stringExtra == null) {
            stringExtra = getString(R.string.change_log_md_date);
        }
        Intrinsics3.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…tring.change_log_md_date)");
        StoreStream.INSTANCE.getChangeLog().markSeen(stringExtra);
        track$default(this, "change_log_closed", null, false, 6, null);
        super.onDestroy();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        VideoView videoView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
        if (videoView.isPlaying()) {
            getBinding().h.pause();
        }
        super.onPause();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.openedTimestamp = ClockFactory.get().currentTimeMillis();
        track$default(this, "change_log_opened", null, false, 2, null);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.whats_new);
        setActionBarSubtitle(getDateString(requireContext()));
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_BODY);
        if (stringExtra == null) {
            stringExtra = getString(R.string.change_log_md_body);
        }
        String str = stringExtra;
        Intrinsics3.checkNotNullExpressionValue(str, "mostRecentIntent.getStri…tring.change_log_md_body)");
        getBinding().f2253b.setDraweeSpanStringBuilder(ChangeLogParser.parse$default(ChangeLogParser.INSTANCE, requireContext(), str, false, new AnonymousClass1(), 4, null));
        String stringExtra2 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_VIDEO);
        if (stringExtra2 == null) {
            stringExtra2 = getString(R.string.change_log_md_video);
        }
        Intrinsics3.checkNotNullExpressionValue(stringExtra2, "mostRecentIntent.getStri…ring.change_log_md_video)");
        configureMedia(stringExtra2);
        configureFooter();
        getBinding().e.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.discord.widgets.changelog.WidgetChangeLog.onViewBound.2
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                WidgetChangeLog widgetChangeLog = WidgetChangeLog.this;
                int i5 = widgetChangeLog.maxScrolledPercent;
                NestedScrollView nestedScrollView2 = WidgetChangeLog.this.getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(nestedScrollView2, "binding.changeLogScrollview");
                int height = ViewExtensions.getContentView(nestedScrollView2).getHeight();
                NestedScrollView nestedScrollView3 = WidgetChangeLog.this.getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(nestedScrollView3, "binding.changeLogScrollview");
                widgetChangeLog.maxScrolledPercent = _Ranges.coerceAtLeast(i5, (i2 * 100) / _Ranges.coerceAtLeast(height - nestedScrollView3.getHeight(), 1));
            }
        });
    }
}
