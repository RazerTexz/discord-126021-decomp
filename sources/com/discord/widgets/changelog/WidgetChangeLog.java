package com.discord.widgets.changelog;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.VideoView;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import b.f.g.a.a.b;
import b.f.g.a.a.d;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChangeLogBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils$UTCFormat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.t;
import d0.t.h0;
import d0.z.d.m;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetChangeLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLog extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChangeLog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChangeLogBinding;", 0)};
    public static final WidgetChangeLog$Companion Companion = new WidgetChangeLog$Companion(null);
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

    public WidgetChangeLog() {
        super(R$layout.widget_change_log);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetChangeLog$binding$2.INSTANCE, new WidgetChangeLog$binding$3(this));
        this.thumbnailControllerListener = new WidgetChangeLog$thumbnailControllerListener$1(this);
    }

    public static final /* synthetic */ WidgetChangeLogBinding access$getBinding$p(WidgetChangeLog widgetChangeLog) {
        return widgetChangeLog.getBinding();
    }

    public static final /* synthetic */ int access$getMaxScrolledPercent$p(WidgetChangeLog widgetChangeLog) {
        return widgetChangeLog.maxScrolledPercent;
    }

    public static final /* synthetic */ void access$hideVideoOverlay(WidgetChangeLog widgetChangeLog) {
        widgetChangeLog.hideVideoOverlay();
    }

    public static final /* synthetic */ void access$onViewBindingDestroy(WidgetChangeLog widgetChangeLog, WidgetChangeLogBinding widgetChangeLogBinding) {
        widgetChangeLog.onViewBindingDestroy(widgetChangeLogBinding);
    }

    public static final /* synthetic */ void access$setMaxScrolledPercent$p(WidgetChangeLog widgetChangeLog, int i) {
        widgetChangeLog.maxScrolledPercent = i;
    }

    public static final /* synthetic */ void access$showVideoOverlay(WidgetChangeLog widgetChangeLog) {
        widgetChangeLog.showVideoOverlay();
    }

    private final void configureFooter() {
        getBinding().g.setOnClickListener(new WidgetChangeLog$configureFooter$1(this));
        getBinding().c.setOnClickListener(new WidgetChangeLog$configureFooter$2(this));
        getBinding().d.setOnClickListener(new WidgetChangeLog$configureFooter$3(this));
    }

    private final void configureMedia(String videoUrl) {
        boolean zEndsWith$default = t.endsWith$default(videoUrl, ".mp4", false, 2, null);
        VideoView videoView = getBinding().h;
        m.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
        videoView.setVisibility(zEndsWith$default ? 0 : 8);
        SimpleDraweeView simpleDraweeView = getBinding().i;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.changeLogVideoOverlay");
        simpleDraweeView.setVisibility(zEndsWith$default ? 0 : 8);
        if (zEndsWith$default) {
            getBinding().h.setVideoPath(videoUrl);
            getBinding().h.setOnCompletionListener(new WidgetChangeLog$configureMedia$1(this));
            getBinding().h.setOnClickListener(new WidgetChangeLog$configureMedia$2(this));
            getBinding().h.setOnPreparedListener(new WidgetChangeLog$configureMedia$3(this));
            return;
        }
        SimpleDraweeView simpleDraweeView2 = getBinding().f;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.changeLogThumbnail");
        simpleDraweeView2.setVisibility(0);
        d dVarA = b.a();
        SimpleDraweeView simpleDraweeView3 = getBinding().f;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.changeLogThumbnail");
        dVarA.n = simpleDraweeView3.getController();
        d dVarG = dVarA.g(videoUrl);
        dVarG.m = false;
        dVarG.k = this.thumbnailControllerListener;
        this.thumbnailDraweeController = dVarG.a();
        SimpleDraweeView simpleDraweeView4 = getBinding().f;
        m.checkNotNullExpressionValue(simpleDraweeView4, "binding.changeLogThumbnail");
        simpleDraweeView4.setController(this.thumbnailDraweeController);
        getBinding().f.requestLayout();
    }

    private final WidgetChangeLogBinding getBinding() {
        return (WidgetChangeLogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CharSequence getDateString(Context context) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_VERSION);
        if (stringExtra == null) {
            stringExtra = getString(2131887518);
        }
        m.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…tring.change_log_md_date)");
        try {
            Date date = new SimpleDateFormat(TimeUtils$UTCFormat.SHORT).parse(stringExtra);
            if (date == null) {
                date = new Date();
            }
            String str = DateFormat.getMediumDateFormat(context).format(date);
            m.checkNotNullExpressionValue(str, "DateFormat.getMediumDate…mat(context).format(date)");
            return str;
        } catch (ParseException unused) {
            return stringExtra;
        }
    }

    private final void hideVideoOverlay() {
        ViewExtensions.fadeOut$default(getBinding().i, 200L, WidgetChangeLog$hideVideoOverlay$1.INSTANCE, null, 4, null);
    }

    public static final void launch(Context context, String str, String str2, String str3, String str4) {
        Companion.launch(context, str, str2, str3, str4);
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
        ViewExtensions.fadeIn$default(getBinding().i, 200L, WidgetChangeLog$showVideoOverlay$1.INSTANCE, WidgetChangeLog$showVideoOverlay$2.INSTANCE, null, 8, null);
    }

    private final void track(String event, Map<String, ? extends Object> properties, boolean includeStats) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_VERSION);
        if (stringExtra == null) {
            stringExtra = getString(2131887518);
        }
        m.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…tring.change_log_md_date)");
        String stringExtra2 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_REVISION);
        if (stringExtra2 == null) {
            stringExtra2 = getString(2131887520);
        }
        m.checkNotNullExpressionValue(stringExtra2, "mostRecentIntent.getStri…g.change_log_md_revision)");
        HashMap map = new HashMap();
        if (includeStats) {
            map.put("seconds_open", Long.valueOf((ClockFactory.get().currentTimeMillis() - this.openedTimestamp) / ((long) 1000)));
            map.put("max_scrolled_percentage", Integer.valueOf(this.maxScrolledPercent));
        }
        AnalyticsTracker.INSTANCE.changeLogEvent(event, stringExtra, stringExtra2, h0.plus(properties, map));
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
            stringExtra = getString(2131887518);
        }
        m.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…tring.change_log_md_date)");
        StoreStream.Companion.getChangeLog().markSeen(stringExtra);
        track$default(this, "change_log_closed", null, false, 6, null);
        super.onDestroy();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        VideoView videoView = getBinding().h;
        m.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
        if (videoView.isPlaying()) {
            getBinding().h.pause();
        }
        super.onPause();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.openedTimestamp = ClockFactory.get().currentTimeMillis();
        track$default(this, "change_log_opened", null, false, 2, null);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(2131897256);
        setActionBarSubtitle(getDateString(requireContext()));
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_BODY);
        if (stringExtra == null) {
            stringExtra = getString(2131887517);
        }
        String str = stringExtra;
        m.checkNotNullExpressionValue(str, "mostRecentIntent.getStri…tring.change_log_md_body)");
        getBinding().f2253b.setDraweeSpanStringBuilder(ChangeLogParser.parse$default(ChangeLogParser.INSTANCE, requireContext(), str, false, new WidgetChangeLog$onViewBound$1(this), 4, null));
        String stringExtra2 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_VIDEO);
        if (stringExtra2 == null) {
            stringExtra2 = getString(2131887521);
        }
        m.checkNotNullExpressionValue(stringExtra2, "mostRecentIntent.getStri…ring.change_log_md_video)");
        configureMedia(stringExtra2);
        configureFooter();
        getBinding().e.setOnScrollChangeListener(new WidgetChangeLog$onViewBound$2(this));
    }
}
