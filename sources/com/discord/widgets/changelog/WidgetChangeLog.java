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
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChangeLogBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
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
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p109f.p132g.p133a.p134a.C1731b;
import p007b.p109f.p132g.p133a.p134a.C1733d;
import p507d0.C12116o;
import p507d0.p512d0.C11226f;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChangeLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLog extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChangeLog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChangeLogBinding;", 0)};

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
    private final WidgetChangeLog$thumbnailControllerListener$1 thumbnailControllerListener;
    private AbstractDraweeController<Object, Object> thumbnailDraweeController;

    /* JADX INFO: compiled from: WidgetChangeLog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, String version, String revision, String video, String body) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(version, "version");
            C12238m.checkNotNullParameter(revision, "revision");
            C12238m.checkNotNullParameter(video, MediaStreamTrack.VIDEO_TRACK_KIND);
            C12238m.checkNotNullParameter(body, "body");
            Bundle bundle = new Bundle();
            bundle.putString(WidgetChangeLog.INTENT_EXTRA_VERSION, version);
            bundle.putString(WidgetChangeLog.INTENT_EXTRA_REVISION, revision);
            bundle.putString(WidgetChangeLog.INTENT_EXTRA_VIDEO, video);
            bundle.putString(WidgetChangeLog.INTENT_EXTRA_BODY, body);
            C0870j.m156d(context, WidgetChangeLog.class, new Intent().putExtras(bundle));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.changelog.WidgetChangeLog$hideVideoOverlay$1 */
    /* JADX INFO: compiled from: WidgetChangeLog.kt */
    public static final class C73111 extends AbstractC12240o implements Function1<ViewPropertyAnimator, Unit> {
        public static final C73111 INSTANCE = new C73111();

        public C73111() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            C12238m.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(2.0f);
            viewPropertyAnimator.scaleY(2.0f);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.changelog.WidgetChangeLog$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetChangeLog.kt */
    public static final class C73121 extends AbstractC12240o implements Function3<Context, String, String, Unit> {
        public C73121() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Context context, String str, String str2) {
            invoke2(context, str, str2);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Context context, String str, String str2) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(str, "url");
            WidgetChangeLog.track$default(WidgetChangeLog.this, "change_log_cta_clicked", C12134g0.mapOf(C12116o.m10073to("cta_type", "inline_link")), false, 4, null);
            UriHandler.handle$default(UriHandler.INSTANCE, context, str, false, false, null, 28, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.changelog.WidgetChangeLog$showVideoOverlay$1 */
    /* JADX INFO: compiled from: WidgetChangeLog.kt */
    public static final class C73141 extends AbstractC12240o implements Function1<View, Unit> {
        public static final C73141 INSTANCE = new C73141();

        public C73141() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "view");
            view.setScaleX(2.0f);
            view.setScaleY(2.0f);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.changelog.WidgetChangeLog$showVideoOverlay$2 */
    /* JADX INFO: compiled from: WidgetChangeLog.kt */
    public static final class C73152 extends AbstractC12240o implements Function1<ViewPropertyAnimator, Unit> {
        public static final C73152 INSTANCE = new C73152();

        public C73152() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            C12238m.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(1.0f);
            viewPropertyAnimator.scaleY(1.0f);
        }
    }

    public WidgetChangeLog() {
        super(C5419R.layout.widget_change_log);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetChangeLog$binding$2.INSTANCE, new WidgetChangeLog$binding$3(this));
        this.thumbnailControllerListener = new WidgetChangeLog$thumbnailControllerListener$1(this);
    }

    private final void configureFooter() {
        getBinding().f15817g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.changelog.WidgetChangeLog.configureFooter.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UriHandler.handle$default(UriHandler.INSTANCE, WidgetChangeLog.this.requireContext(), WidgetChangeLog.this.getString(C5419R.string.twitter_page_url), false, false, null, 28, null);
            }
        });
        getBinding().f15813c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.changelog.WidgetChangeLog.configureFooter.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UriHandler.handle$default(UriHandler.INSTANCE, WidgetChangeLog.this.requireContext(), "https://www.facebook.com/discordapp", false, false, null, 28, null);
            }
        });
        getBinding().f15814d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.changelog.WidgetChangeLog.configureFooter.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UriHandler.handle$default(UriHandler.INSTANCE, WidgetChangeLog.this.requireContext(), "https://www.instagram.com/discord", false, false, null, 28, null);
            }
        });
    }

    private final void configureMedia(String videoUrl) {
        boolean zEndsWith$default = C12103t.endsWith$default(videoUrl, ".mp4", false, 2, null);
        VideoView videoView = getBinding().f15818h;
        C12238m.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
        videoView.setVisibility(zEndsWith$default ? 0 : 8);
        SimpleDraweeView simpleDraweeView = getBinding().f15819i;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.changeLogVideoOverlay");
        simpleDraweeView.setVisibility(zEndsWith$default ? 0 : 8);
        if (zEndsWith$default) {
            getBinding().f15818h.setVideoPath(videoUrl);
            getBinding().f15818h.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.discord.widgets.changelog.WidgetChangeLog.configureMedia.1
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    WidgetChangeLog.this.showVideoOverlay();
                }
            });
            getBinding().f15818h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.changelog.WidgetChangeLog.configureMedia.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoView videoView2 = WidgetChangeLog.this.getBinding().f15818h;
                    C12238m.checkNotNullExpressionValue(videoView2, "binding.changeLogVideo");
                    if (videoView2.isPlaying()) {
                        WidgetChangeLog.this.showVideoOverlay();
                        WidgetChangeLog.this.getBinding().f15818h.pause();
                    } else {
                        WidgetChangeLog.this.hideVideoOverlay();
                        WidgetChangeLog.this.getBinding().f15818h.start();
                    }
                    WidgetChangeLog.track$default(WidgetChangeLog.this, "change_log_video_interacted", null, false, 2, null);
                }
            });
            getBinding().f15818h.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.discord.widgets.changelog.WidgetChangeLog.configureMedia.3
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer) {
                    C12238m.checkNotNullParameter(mediaPlayer, "mp");
                    mediaPlayer.start();
                    mediaPlayer.pause();
                    VideoView videoView2 = WidgetChangeLog.this.getBinding().f15818h;
                    C12238m.checkNotNullExpressionValue(videoView2, "binding.changeLogVideo");
                    videoView2.getLayoutParams().height = -2;
                    WidgetChangeLog.this.getBinding().f15818h.requestLayout();
                }
            });
            return;
        }
        SimpleDraweeView simpleDraweeView2 = getBinding().f15816f;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.changeLogThumbnail");
        simpleDraweeView2.setVisibility(0);
        C1733d c1733dM1037a = C1731b.m1037a();
        SimpleDraweeView simpleDraweeView3 = getBinding().f15816f;
        C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.changeLogThumbnail");
        c1733dM1037a.f19490n = simpleDraweeView3.getController();
        C1733d c1733dM1059g = c1733dM1037a.m1059g(videoUrl);
        c1733dM1059g.f19489m = false;
        c1733dM1059g.f19487k = this.thumbnailControllerListener;
        this.thumbnailDraweeController = c1733dM1059g.m8667a();
        SimpleDraweeView simpleDraweeView4 = getBinding().f15816f;
        C12238m.checkNotNullExpressionValue(simpleDraweeView4, "binding.changeLogThumbnail");
        simpleDraweeView4.setController(this.thumbnailDraweeController);
        getBinding().f15816f.requestLayout();
    }

    private final WidgetChangeLogBinding getBinding() {
        return (WidgetChangeLogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CharSequence getDateString(Context context) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_VERSION);
        if (stringExtra == null) {
            stringExtra = getString(C5419R.string.change_log_md_date);
        }
        C12238m.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…tring.change_log_md_date)");
        try {
            Date date = new SimpleDateFormat(TimeUtils.UTCFormat.SHORT).parse(stringExtra);
            if (date == null) {
                date = new Date();
            }
            String str = DateFormat.getMediumDateFormat(context).format(date);
            C12238m.checkNotNullExpressionValue(str, "DateFormat.getMediumDate…mat(context).format(date)");
            return str;
        } catch (ParseException unused) {
            return stringExtra;
        }
    }

    private final void hideVideoOverlay() {
        ViewExtensions.fadeOut$default(getBinding().f15819i, 200L, C73111.INSTANCE, null, 4, null);
    }

    public static final void launch(Context context, String str, String str2, String str3, String str4) {
        INSTANCE.launch(context, str, str2, str3, str4);
    }

    private final void onViewBindingDestroy(WidgetChangeLogBinding binding) {
        binding.f15818h.setOnPreparedListener(null);
        binding.f15818h.setOnCompletionListener(null);
        AbstractDraweeController<Object, Object> abstractDraweeController = this.thumbnailDraweeController;
        if (abstractDraweeController != null) {
            abstractDraweeController.m8647A(this.thumbnailControllerListener);
        }
    }

    private final void showVideoOverlay() {
        ViewExtensions.fadeIn$default(getBinding().f15819i, 200L, C73141.INSTANCE, C73152.INSTANCE, null, 8, null);
    }

    private final void track(String event, Map<String, ? extends Object> properties, boolean includeStats) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_VERSION);
        if (stringExtra == null) {
            stringExtra = getString(C5419R.string.change_log_md_date);
        }
        C12238m.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…tring.change_log_md_date)");
        String stringExtra2 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_REVISION);
        if (stringExtra2 == null) {
            stringExtra2 = getString(C5419R.string.change_log_md_revision);
        }
        C12238m.checkNotNullExpressionValue(stringExtra2, "mostRecentIntent.getStri…g.change_log_md_revision)");
        HashMap map = new HashMap();
        if (includeStats) {
            map.put("seconds_open", Long.valueOf((ClockFactory.get().currentTimeMillis() - this.openedTimestamp) / ((long) 1000)));
            map.put("max_scrolled_percentage", Integer.valueOf(this.maxScrolledPercent));
        }
        AnalyticsTracker.INSTANCE.changeLogEvent(event, stringExtra, stringExtra2, C12136h0.plus(properties, map));
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
            stringExtra = getString(C5419R.string.change_log_md_date);
        }
        C12238m.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…tring.change_log_md_date)");
        StoreStream.INSTANCE.getChangeLog().markSeen(stringExtra);
        track$default(this, "change_log_closed", null, false, 6, null);
        super.onDestroy();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        VideoView videoView = getBinding().f15818h;
        C12238m.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
        if (videoView.isPlaying()) {
            getBinding().f15818h.pause();
        }
        super.onPause();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.openedTimestamp = ClockFactory.get().currentTimeMillis();
        track$default(this, "change_log_opened", null, false, 2, null);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.whats_new);
        setActionBarSubtitle(getDateString(requireContext()));
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_BODY);
        if (stringExtra == null) {
            stringExtra = getString(C5419R.string.change_log_md_body);
        }
        String str = stringExtra;
        C12238m.checkNotNullExpressionValue(str, "mostRecentIntent.getStri…tring.change_log_md_body)");
        getBinding().f15812b.setDraweeSpanStringBuilder(ChangeLogParser.parse$default(ChangeLogParser.INSTANCE, requireContext(), str, false, new C73121(), 4, null));
        String stringExtra2 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_VIDEO);
        if (stringExtra2 == null) {
            stringExtra2 = getString(C5419R.string.change_log_md_video);
        }
        C12238m.checkNotNullExpressionValue(stringExtra2, "mostRecentIntent.getStri…ring.change_log_md_video)");
        configureMedia(stringExtra2);
        configureFooter();
        getBinding().f15815e.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.discord.widgets.changelog.WidgetChangeLog.onViewBound.2
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                WidgetChangeLog widgetChangeLog = WidgetChangeLog.this;
                int i5 = widgetChangeLog.maxScrolledPercent;
                NestedScrollView nestedScrollView2 = WidgetChangeLog.this.getBinding().f15815e;
                C12238m.checkNotNullExpressionValue(nestedScrollView2, "binding.changeLogScrollview");
                int height = ViewExtensions.getContentView(nestedScrollView2).getHeight();
                NestedScrollView nestedScrollView3 = WidgetChangeLog.this.getBinding().f15815e;
                C12238m.checkNotNullExpressionValue(nestedScrollView3, "binding.changeLogScrollview");
                widgetChangeLog.maxScrolledPercent = C11226f.coerceAtLeast(i5, (i2 * 100) / C11226f.coerceAtLeast(height - nestedScrollView3.getHeight(), 1));
            }
        });
    }
}
