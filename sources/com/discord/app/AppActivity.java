package com.discord.app;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.LocaleList;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;
import b.a.d.AppActivity3;
import b.a.d.AppEventHandlerActivity;
import b.a.d.AppPermissions;
import b.a.d.AppScreen;
import b.a.d.AppScreen2;
import com.discord.R;
import com.discord.app.AppTransitionActivity;
import com.discord.models.domain.ModelUserSettings;
import com.discord.screenshot_detection.ScreenshotDetector;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.ShareUtils;
import com.discord.utilities.accessibility.AccessibilityMonitor;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.bugreports.BugReportManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.views.ToolbarTitleLayout;
import com.discord.widgets.debugging.WidgetFatalCrash;
import com.discord.widgets.share.WidgetIncomingShare;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.voice.call.WidgetVoiceCallIncoming;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.a0.MathJVM;
import d0.e0.KClass;
import d0.z.JvmClassMapping;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Subscription;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/* JADX INFO: compiled from: AppActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public class AppActivity extends AppEventHandlerActivity implements AppComponent {
    public static boolean m;
    public static final Intent n = new Intent();
    public static boolean o = true;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public final LinkedHashMap<Integer, Function1<Intent, Unit>> newIntentListeners = new LinkedHashMap<>();

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public int originalFontScale = -1;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public String originalLocale = "";

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    public boolean refreshEnabled = true;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public final Subject<Void, Void> unsubscribeSignal;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public Toolbar toolbar;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public final Lazy screen;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public Intent mostRecentIntent;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    public final AppPermissions2 appPermissions;

    /* JADX INFO: compiled from: AppActivity.kt */
    public static final class AppAction extends AppActivity {

        /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
        public final Lazy screen = LazyJVM.lazy(new a());

        /* JADX INFO: compiled from: AppActivity.kt */
        public static final class a extends Lambda implements Function0<Class<? extends AppFragment>> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Class<? extends AppFragment> invoke() {
                int iHashCode;
                String action = AppAction.this.c().getAction();
                return (action != null && ((iHashCode = action.hashCode()) == -1173264947 ? action.equals("android.intent.action.SEND") : !(iHashCode == -1103390587 ? !action.equals("com.discord.intent.action.SDK") : !(iHashCode == -58484670 && action.equals("android.intent.action.SEND_MULTIPLE"))))) ? WidgetIncomingShare.class : WidgetTabsHost.class;
            }
        }

        @Override // com.discord.app.AppActivity
        public Class<? extends AppComponent> d() {
            return (Class) this.screen.getValue();
        }

        @Override // com.discord.app.AppActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (AppActivity.m) {
                finish();
            }
        }
    }

    /* JADX INFO: compiled from: AppActivity.kt */
    public static final class Call extends AppActivity {

        /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
        public final Class<? extends AppComponent> screen = WidgetCallFullscreen.class;

        @Override // com.discord.app.AppActivity
        public Class<? extends AppComponent> d() {
            return this.screen;
        }
    }

    /* JADX INFO: compiled from: AppActivity.kt */
    public static final class IncomingCall extends AppActivity {

        /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
        public final Class<? extends AppComponent> screen = WidgetVoiceCallIncoming.SystemCallIncoming.class;

        @Override // com.discord.app.AppActivity
        public Class<? extends AppComponent> d() {
            return this.screen;
        }
    }

    /* JADX INFO: compiled from: AppActivity.kt */
    public static final class Main extends AppActivity {
    }

    /* JADX INFO: compiled from: AppActivity.kt */
    public static final class b extends Lambda implements Function0<Unit> {
        public static final b j = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (AppActivity.o) {
                AppActivity.o = false;
                AppLog.i("Application activity initialized.");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                ApplicationProvider applicationProvider = ApplicationProvider.INSTANCE;
                companion.initialize(applicationProvider.get());
                AnalyticsUtils.INSTANCE.initAppOpen(applicationProvider.get());
                AccessibilityMonitor.INSTANCE.initialize(applicationProvider.get());
                ShareUtils.INSTANCE.updateDirectShareTargets(applicationProvider.get());
                GooglePlayBillingManager.INSTANCE.init(applicationProvider.get());
                AppLog appLog = AppLog.g;
                Intrinsics3.checkNotNullParameter(appLog, "logger");
                Application application = applicationProvider.get();
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationProvider.get());
                Intrinsics3.checkNotNullExpressionValue(defaultSharedPreferences, "PreferenceManager.getDef…pplicationProvider.get())");
                ScreenshotDetector.a = new ScreenshotDetector(application, appLog, defaultSharedPreferences);
                BugReportManager.INSTANCE.init();
            }
        }
    }

    /* JADX INFO: compiled from: AppActivity.kt */
    public static final class c extends Lambda implements Function1<StoreUserSettingsSystem.Settings, Unit> {
        public c() {
            super(1);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0079  */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(StoreUserSettingsSystem.Settings settings) {
            boolean z2;
            StoreUserSettingsSystem.Settings settings2 = settings;
            Intrinsics3.checkNotNullParameter(settings2, "it");
            AppActivity appActivity = AppActivity.this;
            boolean z3 = AppActivity.m;
            Objects.requireNonNull(appActivity);
            Locale localeObject = ModelUserSettings.getLocaleObject(settings2.getLocale());
            Intrinsics3.checkNotNullExpressionValue(localeObject, "ModelUserSettings.getLocaleObject(model.locale)");
            if (!appActivity.f(localeObject)) {
                String theme = settings2.getTheme();
                AppActivity3 appActivity3 = new AppActivity3(appActivity);
                TypedValue typedValue = new TypedValue();
                appActivity3.this$0.getTheme().resolveAttribute(R.attr.theme_name, typedValue, true);
                if (!(!Intrinsics3.areEqual(typedValue.string, theme))) {
                    int fontScale = settings2.getFontScale();
                    FontUtils fontUtils = FontUtils.INSTANCE;
                    ContentResolver contentResolver = appActivity.getContentResolver();
                    Intrinsics3.checkNotNullExpressionValue(contentResolver, "contentResolver");
                    if (!((fontScale == -1 && appActivity.originalFontScale != fontUtils.getSystemFontScaleInt(contentResolver)) || !(fontScale == -1 || appActivity.originalFontScale == fontScale))) {
                        z2 = false;
                    }
                }
                if (z2) {
                    AppActivity.i(AppActivity.this, false, 1, null);
                }
                return Unit.a;
            }
            appActivity.b(settings2.getLocale(), true);
            z2 = true;
            if (z2) {
                AppActivity.i(AppActivity.this, false, 1, null);
            }
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: AppActivity.kt */
    public static final class d extends Lambda implements Function1<ScreenshotDetector.Screenshot, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ScreenshotDetector.Screenshot screenshot) {
            ScreenshotDetector.Screenshot screenshot2 = screenshot;
            Intrinsics3.checkNotNullParameter(screenshot2, "screenshot");
            BugReportManager.INSTANCE.get().onScreenshot(AppActivity.this, screenshot2);
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: AppActivity.kt */
    public static final class e extends Lambda implements Function0<Class<? extends AppComponent>> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Class<? extends AppComponent> invoke() {
            Intent intent = AppActivity.this.getIntent();
            Class<? extends AppComponent> cls = (Class) (intent != null ? intent.getSerializableExtra("com.discord.intent.extra.EXTRA_SCREEN") : null);
            return cls != null ? cls : WidgetTabsHost.class;
        }
    }

    /* JADX INFO: compiled from: AppActivity.kt */
    public static final class f implements Runnable {
        public final /* synthetic */ View j;
        public final /* synthetic */ InputMethodManager k;

        public f(View view, InputMethodManager inputMethodManager) {
            this.j = view;
            this.k = inputMethodManager;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                View editText = this.j;
                if ((editText instanceof TextInputLayout) && (editText = ((TextInputLayout) editText).getEditText()) == null) {
                    editText = this.j;
                }
                editText.requestFocus();
                this.k.showSoftInput(editText, 2);
            } catch (Exception e) {
                AppLog.g.d("Error Opening/Closing the Keyboard", e);
            }
        }
    }

    /* JADX INFO: compiled from: AppActivity.kt */
    public static final class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) throws Exception {
            AppActivity appActivity = AppActivity.this;
            boolean z2 = AppActivity.m;
            appActivity.hideKeyboard(null);
            AppActivity.this.onBackPressed();
        }
    }

    public AppActivity() {
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
        this.screen = LazyJVM.lazy(new e());
        this.mostRecentIntent = n;
        int i = AppPermissions2.a;
        Intrinsics3.checkNotNullParameter(this, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.appPermissions = new AppPermissions(this);
    }

    public static void i(AppActivity appActivity, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        if (appActivity.refreshEnabled) {
            appActivity.finish();
            if (z2) {
                AppTransitionActivity.Transition transition = AppTransitionActivity.Transition.TYPE_FADE;
                appActivity.overridePendingTransition(transition.getAnimations().c, transition.getAnimations().d);
                appActivity.getIntent().putExtra("transition", transition);
            }
            AppScreen2.d(appActivity, appActivity.d(), appActivity.getIntent());
        }
    }

    @Override // android.view.ContextThemeWrapper
    public void applyOverrideConfiguration(Configuration overrideConfiguration) {
        if (overrideConfiguration != null) {
            int i = overrideConfiguration.uiMode;
            Context baseContext = getBaseContext();
            Intrinsics3.checkNotNullExpressionValue(baseContext, "baseContext");
            Resources resources = baseContext.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "baseContext.resources");
            overrideConfiguration.setTo(resources.getConfiguration());
            overrideConfiguration.uiMode = i;
        }
        super.applyOverrideConfiguration(overrideConfiguration);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.discord.utilities.font.FontUtils] */
    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.appcompat.app.AppCompatActivity, com.discord.app.AppActivity] */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context newBase) {
        b.j.invoke2();
        ?? r4 = newBase;
        if (newBase == null) {
            r4 = this;
        }
        ?? r5 = r4;
        if (!o) {
            Resources resources = r4.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "oldContext.resources");
            Configuration configuration = resources.getConfiguration();
            float targetFontScaleFloat = FontUtils.INSTANCE.getTargetFontScaleFloat(r4);
            configuration.fontScale = targetFontScaleFloat;
            this.originalFontScale = MathJVM.roundToInt(targetFontScaleFloat * 100.0f);
            Context contextCreateConfigurationContext = r4.createConfigurationContext(configuration);
            Intrinsics3.checkNotNullExpressionValue(contextCreateConfigurationContext, "oldContext.createConfigurationContext(config)");
            r5 = contextCreateConfigurationContext;
        }
        super.attachBaseContext(r5);
    }

    public final void b(String localeString, boolean refreshIfChanged) {
        Locale localeObject = ModelUserSettings.getLocaleObject(localeString);
        Intrinsics3.checkNotNullExpressionValue(localeObject, "locale");
        if (f(localeObject)) {
            Locale.setDefault(localeObject);
            if (Build.VERSION.SDK_INT >= 24) {
                Resources resources = getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                resources.getConfiguration().setLocale(localeObject);
            } else {
                Resources resources2 = getResources();
                Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
                resources2.getConfiguration().locale = localeObject;
            }
            Resources resources3 = getResources();
            Resources resources4 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources4, "resources");
            Configuration configuration = resources4.getConfiguration();
            Resources resources5 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources5, "resources");
            resources3.updateConfiguration(configuration, resources5.getDisplayMetrics());
            if (refreshIfChanged) {
                i(this, false, 1, null);
            }
        }
    }

    public final Intent c() {
        Intent intent = this.mostRecentIntent;
        Intent intent2 = n;
        if (intent != intent2) {
            return intent;
        }
        Intent intent3 = getIntent();
        return intent3 != null ? intent3 : new Intent(intent2);
    }

    public Class<? extends AppComponent> d() {
        return (Class) this.screen.getValue();
    }

    public final ToolbarTitleLayout e() {
        Toolbar toolbar = this.toolbar;
        View childAt = toolbar != null ? toolbar.getChildAt(0) : null;
        return (ToolbarTitleLayout) (childAt instanceof ToolbarTitleLayout ? childAt : null);
    }

    public final boolean f(Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            Resources resources = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            Configuration configuration = resources.getConfiguration();
            Intrinsics3.checkNotNullExpressionValue(configuration, "resources.configuration");
            LocaleList locales = configuration.getLocales();
            Intrinsics3.checkNotNullExpressionValue(locales, "resources.configuration.locales");
            if (!locales.isEmpty()) {
                Resources resources2 = getResources();
                Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
                Configuration configuration2 = resources2.getConfiguration();
                Intrinsics3.checkNotNullExpressionValue(configuration2, "resources.configuration");
                if (!(!Intrinsics3.areEqual(configuration2.getLocales().get(0), locale))) {
                    return false;
                }
            }
        } else {
            Resources resources3 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources3, "resources");
            if (resources3.getConfiguration().locale != null) {
                Resources resources4 = getResources();
                Intrinsics3.checkNotNullExpressionValue(resources4, "resources");
                if (!(!Intrinsics3.areEqual(resources4.getConfiguration().locale, locale))) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean g(List<? extends KClass<? extends AppComponent>> screens) {
        Intrinsics3.checkNotNullParameter(screens, "screens");
        if ((screens instanceof Collection) && screens.isEmpty()) {
            return false;
        }
        Iterator<T> it = screens.iterator();
        while (it.hasNext()) {
            if (Intrinsics3.areEqual(JvmClassMapping.getJavaClass((KClass) it.next()), d())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.unsubscribeSignal;
    }

    public final boolean h(KClass<? extends AppComponent> screen) {
        Intrinsics3.checkNotNullParameter(screen, "screen");
        return Intrinsics3.areEqual(JvmClassMapping.getJavaClass(screen), d());
    }

    public final void hideKeyboard(View view) {
        m(false, view);
    }

    public final void j(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (h(Reflection2.getOrCreateKotlinClass(WidgetTabsHost.class))) {
            return;
        }
        List<KClass<? extends AppFragment>> list = AppScreen2.a;
        Intrinsics3.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.addFlags(67108864);
        AppScreen2.c(context, false, intent, 2);
    }

    public final Toolbar k(boolean showHomeAsUp, @DrawableRes Integer iconRes, @StringRes Integer iconAccessibilityLabel) {
        Toolbar toolbar = this.toolbar;
        Drawable drawable = null;
        if (toolbar == null) {
            return null;
        }
        if (showHomeAsUp) {
            int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(toolbar, R.attr.ic_action_bar_back, 0, 2, (Object) null);
            Context context = toolbar.getContext();
            if (iconRes != null) {
                themedDrawableRes$default = iconRes.intValue();
            }
            drawable = ContextCompat.getDrawable(context, themedDrawableRes$default);
            if (drawable != null) {
                androidx.core.graphics.drawable.DrawableCompat.setTint(drawable, ColorCompat.getThemedColor(toolbar, R.attr.colorInteractiveActive));
            }
            toolbar.setNavigationContentDescription(getString(R.string.back));
        }
        toolbar.setNavigationIcon(drawable);
        if (iconAccessibilityLabel == null) {
            return toolbar;
        }
        toolbar.setNavigationContentDescription(getString(iconAccessibilityLabel.intValue()));
        return toolbar;
    }

    public final Unit l(CharSequence title, @DrawableRes Integer leftDrawable) {
        ToolbarTitleLayout toolbarTitleLayoutE = e();
        if (toolbarTitleLayoutE == null) {
            return null;
        }
        int i = ToolbarTitleLayout.j;
        toolbarTitleLayoutE.a(title, leftDrawable, null);
        return Unit.a;
    }

    public final void m(boolean keyboardOpen, View view) {
        IBinder applicationWindowToken;
        View childAt;
        Object systemService = getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (view == null || (applicationWindowToken = view.getWindowToken()) == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(android.R.id.content);
            applicationWindowToken = (frameLayout == null || (childAt = frameLayout.getChildAt(0)) == null) ? null : childAt.getApplicationWindowToken();
        }
        if (keyboardOpen) {
            if (view != null) {
                view.postDelayed(new f(view, inputMethodManager), 250L);
            }
        } else {
            try {
                inputMethodManager.hideSoftInputFromWindow(applicationWindowToken, 0);
            } catch (Exception e2) {
                AppLog.g.d("Error Opening/Closing the Keyboard", e2);
            }
        }
    }

    public final void n(Toolbar toolbar) {
        this.toolbar = toolbar;
        if (e() == null) {
            Toolbar toolbar2 = this.toolbar;
            if (toolbar2 != null) {
                toolbar2.addView(new ToolbarTitleLayout(this), 0);
            }
            ToolbarTitleLayout toolbarTitleLayoutE = e();
            if (toolbarTitleLayoutE != null) {
                toolbarTitleLayoutE.setBackground(ContextCompat.getDrawable(this, DrawableCompat.getThemedDrawableRes$default(this, R.attr.selectableItemBackground, 0, 2, (Object) null)));
            }
            Toolbar toolbar3 = this.toolbar;
            if (toolbar3 != null) {
                toolbar3.setNavigationOnClickListener(new g());
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a aVar = new a(0, this);
        a aVar2 = new a(1, this);
        try {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            String theme = companion.getUserSettingsSystem().getTheme();
            int i = 2131951650;
            if (Intrinsics3.areEqual(theme, ModelUserSettings.THEME_LIGHT)) {
                i = 2131951657;
            } else if (!Intrinsics3.areEqual(theme, ModelUserSettings.THEME_DARK) && Intrinsics3.areEqual(theme, ModelUserSettings.THEME_PURE_EVIL)) {
                i = 2131951652;
            }
            setTheme(i);
            b(companion.getUserSettingsSystem().getLocale(), false);
            aVar.invoke2();
            aVar2.invoke2();
            if (h(Reflection2.getOrCreateKotlinClass(WidgetTabsHost.class)) && companion.getTabsNavigation().getSelectedTab() == NavigationTab.HOME) {
                return;
            }
            companion.getAnalytics().appUiViewed(d());
        } catch (Exception e2) {
            if (!h(Reflection2.getOrCreateKotlinClass(WidgetFatalCrash.class))) {
                WidgetFatalCrash.Companion companion2 = WidgetFatalCrash.INSTANCE;
                String name = d().getName();
                Intrinsics3.checkNotNullExpressionValue(name, "screen.name");
                companion2.launch(this, e2, name);
            }
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.newIntentListeners.clear();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null) {
            intent = n;
        }
        this.mostRecentIntent = intent;
        m = IntentUtils.INSTANCE.consumeExternalRoutingIntent(c(), this);
        Intent intentC = c();
        Iterator<Map.Entry<Integer, Function1<Intent, Unit>>> it = this.newIntentListeners.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().invoke(intentC);
        }
    }

    @Override // com.discord.app.AppTransitionActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.unsubscribeSignal.onNext(null);
    }

    @Override // com.discord.app.AppTransitionActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        AppScreen2 appScreen2 = AppScreen2.g;
        Intrinsics3.checkNotNullParameter(this, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        boolean booleanExtra = c().getBooleanExtra("INTENT_RECREATE", false);
        if (booleanExtra) {
            c().removeExtra("INTENT_RECREATE");
            new Handler(Looper.getMainLooper()).post(new AppScreen(this));
        }
        if (booleanExtra) {
            return;
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        if ((!Intrinsics3.areEqual(companion.getUserSettingsSystem().getLocale(), this.originalLocale)) && (!Intrinsics3.areEqual(this.originalLocale, ""))) {
            i(this, false, 1, null);
            return;
        }
        this.originalLocale = companion.getUserSettingsSystem().getLocale();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(companion.getUserSettingsSystem().observeSettings(true), this, null, 2, null), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new c());
        ScreenshotDetector screenshotDetector = ScreenshotDetector.a;
        if (screenshotDetector == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("screenshotDetector");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(screenshotDetector.publishSubject, this, null, 2, null), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new d());
    }

    public final void showKeyboard(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        m(true, view);
    }

    /* JADX INFO: compiled from: kotlin-style lambda group */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.j = i;
            this.k = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.j;
            if (i == 0) {
                invoke2();
                return Unit.a;
            }
            if (i != 1) {
                throw null;
            }
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            int i = this.j;
            if (i != 0) {
                if (i == 1) {
                    Objects.requireNonNull((AppActivity) this.k);
                    AppActivity appActivity = (AppActivity) this.k;
                    if (appActivity.toolbar == null) {
                        appActivity.n((Toolbar) appActivity.findViewById(R.id.action_bar_toolbar));
                        return;
                    }
                    return;
                }
                throw null;
            }
            AppActivity appActivity2 = (AppActivity) this.k;
            AppActivity.m = IntentUtils.INSTANCE.consumeExternalRoutingIntent(appActivity2.c(), appActivity2);
            Intent intentC = ((AppActivity) this.k).c();
            AppActivity appActivity3 = (AppActivity) this.k;
            Objects.requireNonNull(appActivity3);
            Serializable serializableExtra = intentC != null ? intentC.getSerializableExtra("transition") : null;
            if (!(serializableExtra instanceof AppTransitionActivity.Transition)) {
                serializableExtra = null;
            }
            AppTransitionActivity.Transition transition = (AppTransitionActivity.Transition) serializableExtra;
            if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
                transition = AppTransitionActivity.Transition.TYPE_FADE_FAST;
            } else if (transition == null) {
                AppScreen2 appScreen2 = AppScreen2.g;
                transition = appActivity3.g(AppScreen2.d) ? AppTransitionActivity.Transition.TYPE_SLIDE_HORIZONTAL : null;
            }
            appActivity3.k = transition != null ? transition.getAnimations() : null;
            if (((AppActivity) this.k).getSupportFragmentManager().findFragmentByTag(((AppActivity) this.k).d().getName()) != null) {
                return;
            }
            AppScreen2 appScreen3 = AppScreen2.g;
            FragmentManager supportFragmentManager = ((AppActivity) this.k).getSupportFragmentManager();
            AppActivity appActivity4 = (AppActivity) this.k;
            AppScreen2.g(appScreen3, supportFragmentManager, appActivity4, appActivity4.d(), 0, false, null, null, 120);
        }
    }
}
