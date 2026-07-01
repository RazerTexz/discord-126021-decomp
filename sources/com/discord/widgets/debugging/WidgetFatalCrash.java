package com.discord.widgets.debugging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetFatalCrashBinding;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetFatalCrash.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFatalCrash extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetFatalCrash.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFatalCrashBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CRASH_SOURCE = "INTENT_EXTRA_CRASH_SOURCE";
    private static final String INTENT_EXTRA_CRASH_TIME = "INTENT_EXTRA_CRASH_TIME";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetFatalCrash.kt */
    public static final class Companion {
        private Companion() {
        }

        @SuppressLint({"SimpleDateFormat"})
        private final Intent createIntent(String source) {
            Bundle bundle = new Bundle();
            bundle.putString(WidgetFatalCrash.INTENT_EXTRA_CRASH_SOURCE, source);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            bundle.putString(WidgetFatalCrash.INTENT_EXTRA_CRASH_TIME, simpleDateFormat.format(new Date()) + " GMT");
            Intent intentPutExtras = new Intent().putExtras(bundle);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtras, "Intent().putExtras(extras)");
            return intentPutExtras;
        }

        public final void launch(Context context, Throwable throwable, String crashSource) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(throwable, "throwable");
            Intrinsics3.checkNotNullParameter(crashSource, "crashSource");
            AppLog appLog = AppLog.g;
            String simpleName = WidgetFatalCrash.class.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName, "WidgetFatalCrash::class.java.simpleName");
            Logger.e$default(appLog, simpleName, new Throwable(crashSource, throwable), null, 4, null);
            AppScreen2.d(context, WidgetFatalCrash.class, createIntent(crashSource));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetFatalCrash() {
        super(R.layout.widget_fatal_crash);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetFatalCrash2.INSTANCE, null, 2, null);
    }

    private final WidgetFatalCrashBinding getBinding() {
        return (WidgetFatalCrashBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context, Throwable th, String str) {
        INSTANCE.launch(context, th, str);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        LinkifiedTextView linkifiedTextView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.fatalCrashTestersInvite");
        linkifiedTextView.setText(FormatUtils.e(this, R.string.crash_testers_invite, new Object[]{"https://discord.gg/discord-testers"}, (4 & 4) != 0 ? FormatUtils.a.j : null));
        Bundle extras = getMostRecentIntent().getExtras();
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.fatalCrashSource");
        Object[] objArr = new Object[1];
        objArr[0] = extras != null ? extras.getString(INTENT_EXTRA_CRASH_SOURCE, getString(R.string.status_unknown)) : null;
        textView.setText(FormatUtils.e(this, R.string.crash_source, objArr, (4 & 4) != 0 ? FormatUtils.a.j : null));
        TextView textView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.fatalCrashTime");
        Object[] objArr2 = new Object[1];
        objArr2[0] = extras != null ? extras.getString(INTENT_EXTRA_CRASH_TIME) : null;
        textView2.setText(FormatUtils.e(this, R.string.crash_timestamp, objArr2, (4 & 4) != 0 ? FormatUtils.a.j : null));
        TextView textView3 = getBinding().f2384b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.fatalCrashAppVersion");
        textView3.setText(FormatUtils.e(this, R.string.crash_app_version, new Object[]{BuildConfig.VERSION_NAME}, (4 & 4) != 0 ? FormatUtils.a.j : null));
        TextView textView4 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.fatalCrashOsVersion");
        textView4.setText(FormatUtils.e(this, R.string.crash_device_version, new Object[]{String.valueOf(Build.VERSION.SDK_INT)}, (4 & 4) != 0 ? FormatUtils.a.j : null));
        TextView textView5 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.fatalCrashDevice");
        textView5.setText(FormatUtils.e(this, R.string.crash_device, new Object[]{Build.MODEL + ' ' + Build.PRODUCT}, (4 & 4) != 0 ? FormatUtils.a.j : null));
    }
}
