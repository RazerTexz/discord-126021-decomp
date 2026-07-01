package com.discord.widgets.changelog;

import android.content.Context;
import android.text.format.DateFormat;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout$LayoutParams;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import b.f.g.a.a.b;
import b.f.g.a.a.d;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChangeLogSpecialBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils$UTCFormat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
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
import java.util.Objects;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetChangeLogSpecial.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLogSpecial extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChangeLogSpecial.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChangeLogSpecialBinding;", 0)};
    public static final WidgetChangeLogSpecial$Companion Companion = new WidgetChangeLogSpecial$Companion(null);
    private static final String INTENT_EXTRA_BODY = "INTENT_EXTRA_BODY";
    private static final String INTENT_EXTRA_EXIT_STYLE = "INTENT_EXTRA_EXIT_STYLE";
    private static final String INTENT_EXTRA_HIDE_VIDEO = "INTENT_EXTRA_HIDE_VIDEO";
    private static final String INTENT_EXTRA_REVISION = "INTENT_EXTRA_REVISION";
    private static final String INTENT_EXTRA_VERSION = "INTENT_EXTRA_VERSION";
    private static final String INTENT_EXTRA_VIDEO = "INTENT_EXTRA_VIDEO";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private int maxScrolledPercent;
    private long openedTimestamp;
    private final WidgetChangeLogSpecial$thumbnailControllerListener$1 thumbnailControllerListener;
    private AbstractDraweeController<Object, Object> thumbnailDraweeController;

    public WidgetChangeLogSpecial() {
        super(R$layout.widget_change_log_special);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetChangeLogSpecial$binding$2.INSTANCE, new WidgetChangeLogSpecial$binding$3(this));
        this.thumbnailControllerListener = new WidgetChangeLogSpecial$thumbnailControllerListener$1(this);
    }

    public static final /* synthetic */ WidgetChangeLogSpecialBinding access$getBinding$p(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        return widgetChangeLogSpecial.getBinding();
    }

    public static final /* synthetic */ int access$getMaxScrolledPercent$p(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        return widgetChangeLogSpecial.maxScrolledPercent;
    }

    public static final /* synthetic */ void access$hideVideoOverlay(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        widgetChangeLogSpecial.hideVideoOverlay();
    }

    public static final /* synthetic */ void access$onViewBindingDestroy(WidgetChangeLogSpecial widgetChangeLogSpecial, WidgetChangeLogSpecialBinding widgetChangeLogSpecialBinding) {
        widgetChangeLogSpecial.onViewBindingDestroy(widgetChangeLogSpecialBinding);
    }

    public static final /* synthetic */ void access$setMaxScrolledPercent$p(WidgetChangeLogSpecial widgetChangeLogSpecial, int i) {
        widgetChangeLogSpecial.maxScrolledPercent = i;
    }

    public static final /* synthetic */ void access$showVideoOverlay(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        widgetChangeLogSpecial.showVideoOverlay();
    }

    private final void configureMedia(String videoUrl) {
        boolean zEndsWith$default = t.endsWith$default(videoUrl, ".mp4", false, 2, null);
        VideoView videoView = getBinding().i;
        m.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
        videoView.setVisibility(zEndsWith$default ? 0 : 8);
        SimpleDraweeView simpleDraweeView = getBinding().j;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.changeLogVideoOverlay");
        simpleDraweeView.setVisibility(zEndsWith$default ? 0 : 8);
        if (zEndsWith$default) {
            getBinding().i.setVideoPath(videoUrl);
            getBinding().i.setOnCompletionListener(new WidgetChangeLogSpecial$configureMedia$1(this));
            getBinding().i.setOnClickListener(new WidgetChangeLogSpecial$configureMedia$2(this));
            getBinding().i.setOnPreparedListener(new WidgetChangeLogSpecial$configureMedia$3(this));
            return;
        }
        SimpleDraweeView simpleDraweeView2 = getBinding().h;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.changeLogThumbnail");
        simpleDraweeView2.setVisibility(0);
        d dVarA = b.a();
        SimpleDraweeView simpleDraweeView3 = getBinding().h;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.changeLogThumbnail");
        dVarA.n = simpleDraweeView3.getController();
        d dVarG = dVarA.g(videoUrl);
        dVarG.m = false;
        dVarG.k = this.thumbnailControllerListener;
        this.thumbnailDraweeController = dVarG.a();
        SimpleDraweeView simpleDraweeView4 = getBinding().h;
        m.checkNotNullExpressionValue(simpleDraweeView4, "binding.changeLogThumbnail");
        simpleDraweeView4.setController(this.thumbnailDraweeController);
        getBinding().h.requestLayout();
    }

    private final WidgetChangeLogSpecialBinding getBinding() {
        return (WidgetChangeLogSpecialBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
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
            return " " + DateFormat.getMediumDateFormat(context).format(date) + " ";
        } catch (ParseException unused) {
            return stringExtra;
        }
    }

    private final void hideVideoOverlay() {
        ViewExtensions.fadeOut$default(getBinding().j, 200L, WidgetChangeLogSpecial$hideVideoOverlay$1.INSTANCE, null, 4, null);
    }

    public static final void launch(Context context, String str, String str2, String str3, String str4, WidgetChangeLogSpecial$Companion$ExitStyle widgetChangeLogSpecial$Companion$ExitStyle, boolean z2) {
        Companion.launch(context, str, str2, str3, str4, widgetChangeLogSpecial$Companion$ExitStyle, z2);
    }

    private final void onViewBindingDestroy(WidgetChangeLogSpecialBinding binding) {
        binding.i.setOnPreparedListener(null);
        binding.i.setOnCompletionListener(null);
        AbstractDraweeController<Object, Object> abstractDraweeController = this.thumbnailDraweeController;
        if (abstractDraweeController != null) {
            abstractDraweeController.A(this.thumbnailControllerListener);
        }
    }

    private final void showVideoOverlay() {
        ViewExtensions.fadeIn$default(getBinding().j, 200L, WidgetChangeLogSpecial$showVideoOverlay$1.INSTANCE, WidgetChangeLogSpecial$showVideoOverlay$2.INSTANCE, null, 8, null);
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
    public static /* synthetic */ void track$default(WidgetChangeLogSpecial widgetChangeLogSpecial, String str, Map map, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            map = new HashMap();
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        widgetChangeLogSpecial.track(str, map, z2);
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
        VideoView videoView = getBinding().i;
        m.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
        if (videoView.isPlaying()) {
            getBinding().i.pause();
        }
        super.onPause();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.openedTimestamp = ClockFactory.get().currentTimeMillis();
        track$default(this, "change_log_opened", null, false, 2, null);
        setActionBarSubtitle(getDateString(requireContext()));
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_BODY);
        if (stringExtra == null) {
            stringExtra = getString(2131887517);
        }
        m.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…tring.change_log_md_body)");
        if (getMostRecentIntent().getSerializableExtra(INTENT_EXTRA_EXIT_STYLE) == WidgetChangeLogSpecial$Companion$ExitStyle.BACK) {
            ImageButton imageButton = getBinding().e;
            m.checkNotNullExpressionValue(imageButton, "binding.changeLogSpecialClose");
            imageButton.setVisibility(8);
            ImageButton imageButton2 = getBinding().c;
            m.checkNotNullExpressionValue(imageButton2, "binding.changeLogSpecialBack");
            imageButton2.setVisibility(0);
        }
        TextView textView = getBinding().f;
        m.checkNotNullExpressionValue(textView, "binding.changeLogSpecialDate");
        textView.setText(getDateString(requireContext()));
        getBinding().f2254b.setDraweeSpanStringBuilder(ChangeLogParser.INSTANCE.parse(requireContext(), stringExtra, true, new WidgetChangeLogSpecial$onViewBound$1(this)));
        String stringExtra2 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_VIDEO);
        if (stringExtra2 == null) {
            stringExtra2 = getString(2131887521);
        }
        m.checkNotNullExpressionValue(stringExtra2, "mostRecentIntent.getStri…ring.change_log_md_video)");
        configureMedia(stringExtra2);
        getBinding().c.setOnClickListener(new WidgetChangeLogSpecial$onViewBound$2(this));
        getBinding().e.setOnClickListener(new WidgetChangeLogSpecial$onViewBound$3(this));
        LinkifiedTextView linkifiedTextView = getBinding().f2254b;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.changeLogBody");
        b.a.k.b.n(linkifiedTextView, 2131887533, new Object[0], null, 4);
        LinkifiedTextView linkifiedTextView2 = getBinding().f2254b;
        m.checkNotNullExpressionValue(linkifiedTextView2, "binding.changeLogBody");
        linkifiedTextView2.setMovementMethod(LinkMovementMethod.getInstance());
        getBinding().d.setOnClickListener(new WidgetChangeLogSpecial$onViewBound$4(this));
        if (getMostRecentIntent().getBooleanExtra(INTENT_EXTRA_HIDE_VIDEO, false)) {
            VideoView videoView = getBinding().i;
            m.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
            videoView.setVisibility(8);
            CardView cardView = getBinding().k;
            m.checkNotNullExpressionValue(cardView, "binding.changelogSpecialHeaderContainer");
            ViewGroup$LayoutParams layoutParams = cardView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout$LayoutParams linearLayout$LayoutParams = (LinearLayout$LayoutParams) layoutParams;
            linearLayout$LayoutParams.setMargins(linearLayout$LayoutParams.leftMargin, linearLayout$LayoutParams.topMargin, linearLayout$LayoutParams.rightMargin, DimenUtils.dpToPixels(16));
        }
        getBinding().g.setOnScrollChangeListener(new WidgetChangeLogSpecial$onViewBound$5(this));
    }
}
