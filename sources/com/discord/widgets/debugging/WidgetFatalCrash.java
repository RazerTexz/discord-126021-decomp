package com.discord.widgets.debugging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.BuildConfig;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetFatalCrashBinding;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetFatalCrash.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFatalCrash extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetFatalCrash.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFatalCrashBinding;", 0)};

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
            C12238m.checkNotNullExpressionValue(intentPutExtras, "Intent().putExtras(extras)");
            return intentPutExtras;
        }

        public final void launch(Context context, Throwable throwable, String crashSource) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(throwable, "throwable");
            C12238m.checkNotNullParameter(crashSource, "crashSource");
            AppLog appLog = AppLog.f14950g;
            String simpleName = WidgetFatalCrash.class.getSimpleName();
            C12238m.checkNotNullExpressionValue(simpleName, "WidgetFatalCrash::class.java.simpleName");
            Logger.e$default(appLog, simpleName, new Throwable(crashSource, throwable), null, 4, null);
            C0870j.m156d(context, WidgetFatalCrash.class, createIntent(crashSource));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetFatalCrash() {
        super(C5419R.layout.widget_fatal_crash);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetFatalCrash$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetFatalCrashBinding getBinding() {
        return (WidgetFatalCrashBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context, Throwable th, String str) {
        INSTANCE.launch(context, th, str);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        LinkifiedTextView linkifiedTextView = getBinding().f16621f;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.fatalCrashTestersInvite");
        linkifiedTextView.setText(C1107b.m213e(this, C5419R.string.crash_testers_invite, new Object[]{"https://discord.gg/discord-testers"}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
        Bundle extras = getMostRecentIntent().getExtras();
        TextView textView = getBinding().f16620e;
        C12238m.checkNotNullExpressionValue(textView, "binding.fatalCrashSource");
        Object[] objArr = new Object[1];
        objArr[0] = extras != null ? extras.getString(INTENT_EXTRA_CRASH_SOURCE, getString(C5419R.string.status_unknown)) : null;
        textView.setText(C1107b.m213e(this, C5419R.string.crash_source, objArr, (4 & 4) != 0 ? C1107b.a.f1490j : null));
        TextView textView2 = getBinding().f16622g;
        C12238m.checkNotNullExpressionValue(textView2, "binding.fatalCrashTime");
        Object[] objArr2 = new Object[1];
        objArr2[0] = extras != null ? extras.getString(INTENT_EXTRA_CRASH_TIME) : null;
        textView2.setText(C1107b.m213e(this, C5419R.string.crash_timestamp, objArr2, (4 & 4) != 0 ? C1107b.a.f1490j : null));
        TextView textView3 = getBinding().f16617b;
        C12238m.checkNotNullExpressionValue(textView3, "binding.fatalCrashAppVersion");
        textView3.setText(C1107b.m213e(this, C5419R.string.crash_app_version, new Object[]{BuildConfig.VERSION_NAME}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
        TextView textView4 = getBinding().f16619d;
        C12238m.checkNotNullExpressionValue(textView4, "binding.fatalCrashOsVersion");
        textView4.setText(C1107b.m213e(this, C5419R.string.crash_device_version, new Object[]{String.valueOf(Build.VERSION.SDK_INT)}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
        TextView textView5 = getBinding().f16618c;
        C12238m.checkNotNullExpressionValue(textView5, "binding.fatalCrashDevice");
        textView5.setText(C1107b.m213e(this, C5419R.string.crash_device, new Object[]{Build.MODEL + ' ' + Build.PRODUCT}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
    }
}
