package com.discord.app;

import android.R$id;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.LocaleList;
import android.os.Looper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import b.a.d.d;
import b.a.d.h;
import b.a.d.i;
import b.a.d.j;
import com.discord.models.domain.ModelUserSettings;
import com.discord.screenshot_detection.ScreenshotDetector;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.views.ToolbarTitleLayout;
import com.discord.widgets.debugging.WidgetFatalCrash;
import com.discord.widgets.debugging.WidgetFatalCrash$Companion;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.WidgetTabsHost;
import d0.a0.a;
import d0.e0.c;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map$Entry;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/* JADX INFO: compiled from: AppActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public class AppActivity extends d implements AppComponent {
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
    public final AppPermissionsRequests appPermissions;

    public AppActivity() {
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
        this.screen = g.lazy(new AppActivity$e(this));
        this.mostRecentIntent = n;
        int i = AppPermissionsRequests.a;
        m.checkNotNullParameter(this, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.appPermissions = new h(this);
    }

    public static void i(AppActivity appActivity, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        if (appActivity.refreshEnabled) {
            appActivity.finish();
            if (z2) {
                AppTransitionActivity$Transition appTransitionActivity$Transition = AppTransitionActivity$Transition.TYPE_FADE;
                appActivity.overridePendingTransition(appTransitionActivity$Transition.getAnimations().c, appTransitionActivity$Transition.getAnimations().d);
                appActivity.getIntent().putExtra("transition", appTransitionActivity$Transition);
            }
            j.d(appActivity, appActivity.d(), appActivity.getIntent());
        }
    }

    @Override // android.view.ContextThemeWrapper
    public void applyOverrideConfiguration(Configuration overrideConfiguration) {
        if (overrideConfiguration != null) {
            int i = overrideConfiguration.uiMode;
            Context baseContext = getBaseContext();
            m.checkNotNullExpressionValue(baseContext, "baseContext");
            Resources resources = baseContext.getResources();
            m.checkNotNullExpressionValue(resources, "baseContext.resources");
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
        AppActivity$b.j.invoke2();
        ?? r4 = newBase;
        if (newBase == null) {
            r4 = this;
        }
        ?? r5 = r4;
        if (!o) {
            Resources resources = r4.getResources();
            m.checkNotNullExpressionValue(resources, "oldContext.resources");
            Configuration configuration = resources.getConfiguration();
            float targetFontScaleFloat = FontUtils.INSTANCE.getTargetFontScaleFloat(r4);
            configuration.fontScale = targetFontScaleFloat;
            this.originalFontScale = a.roundToInt(targetFontScaleFloat * 100.0f);
            Context contextCreateConfigurationContext = r4.createConfigurationContext(configuration);
            m.checkNotNullExpressionValue(contextCreateConfigurationContext, "oldContext.createConfigurationContext(config)");
            r5 = contextCreateConfigurationContext;
        }
        super.attachBaseContext(r5);
    }

    public final void b(String localeString, boolean refreshIfChanged) {
        Locale localeObject = ModelUserSettings.getLocaleObject(localeString);
        m.checkNotNullExpressionValue(localeObject, "locale");
        if (f(localeObject)) {
            Locale.setDefault(localeObject);
            if (Build$VERSION.SDK_INT >= 24) {
                Resources resources = getResources();
                m.checkNotNullExpressionValue(resources, "resources");
                resources.getConfiguration().setLocale(localeObject);
            } else {
                Resources resources2 = getResources();
                m.checkNotNullExpressionValue(resources2, "resources");
                resources2.getConfiguration().locale = localeObject;
            }
            Resources resources3 = getResources();
            Resources resources4 = getResources();
            m.checkNotNullExpressionValue(resources4, "resources");
            Configuration configuration = resources4.getConfiguration();
            Resources resources5 = getResources();
            m.checkNotNullExpressionValue(resources5, "resources");
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
        if (Build$VERSION.SDK_INT >= 24) {
            Resources resources = getResources();
            m.checkNotNullExpressionValue(resources, "resources");
            Configuration configuration = resources.getConfiguration();
            m.checkNotNullExpressionValue(configuration, "resources.configuration");
            LocaleList locales = configuration.getLocales();
            m.checkNotNullExpressionValue(locales, "resources.configuration.locales");
            if (!locales.isEmpty()) {
                Resources resources2 = getResources();
                m.checkNotNullExpressionValue(resources2, "resources");
                Configuration configuration2 = resources2.getConfiguration();
                m.checkNotNullExpressionValue(configuration2, "resources.configuration");
                if (!(!m.areEqual(configuration2.getLocales().get(0), locale))) {
                    return false;
                }
            }
        } else {
            Resources resources3 = getResources();
            m.checkNotNullExpressionValue(resources3, "resources");
            if (resources3.getConfiguration().locale != null) {
                Resources resources4 = getResources();
                m.checkNotNullExpressionValue(resources4, "resources");
                if (!(!m.areEqual(resources4.getConfiguration().locale, locale))) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean g(List<? extends c<? extends AppComponent>> screens) {
        m.checkNotNullParameter(screens, "screens");
        if ((screens instanceof Collection) && screens.isEmpty()) {
            return false;
        }
        Iterator<T> it = screens.iterator();
        while (it.hasNext()) {
            if (m.areEqual(d0.z.a.getJavaClass((c) it.next()), d())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.unsubscribeSignal;
    }

    public final boolean h(c<? extends AppComponent> screen) {
        m.checkNotNullParameter(screen, "screen");
        return m.areEqual(d0.z.a.getJavaClass(screen), d());
    }

    public final void hideKeyboard(View view) {
        m(false, view);
    }

    public final void j(Context context) {
        m.checkNotNullParameter(context, "context");
        if (h(a0.getOrCreateKotlinClass(WidgetTabsHost.class))) {
            return;
        }
        List<c<? extends AppFragment>> list = j.a;
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.addFlags(67108864);
        j.c(context, false, intent, 2);
    }

    public final Toolbar k(boolean showHomeAsUp, @DrawableRes Integer iconRes, @StringRes Integer iconAccessibilityLabel) {
        Toolbar toolbar = this.toolbar;
        Drawable drawable = null;
        if (toolbar == null) {
            return null;
        }
        if (showHomeAsUp) {
            int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(toolbar, 2130969454, 0, 2, (Object) null);
            Context context = toolbar.getContext();
            if (iconRes != null) {
                themedDrawableRes$default = iconRes.intValue();
            }
            drawable = ContextCompat.getDrawable(context, themedDrawableRes$default);
            if (drawable != null) {
                androidx.core.graphics.drawable.DrawableCompat.setTint(drawable, ColorCompat.getThemedColor(toolbar, 2130969005));
            }
            toolbar.setNavigationContentDescription(getString(2131886994));
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
            FrameLayout frameLayout = (FrameLayout) findViewById(R$id.content);
            applicationWindowToken = (frameLayout == null || (childAt = frameLayout.getChildAt(0)) == null) ? null : childAt.getApplicationWindowToken();
        }
        if (keyboardOpen) {
            if (view != null) {
                view.postDelayed(new AppActivity$f(view, inputMethodManager), 250L);
            }
        } else {
            try {
                inputMethodManager.hideSoftInputFromWindow(applicationWindowToken, 0);
            } catch (Exception e) {
                AppLog.g.d("Error Opening/Closing the Keyboard", e);
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
                toolbarTitleLayoutE.setBackground(ContextCompat.getDrawable(this, DrawableCompat.getThemedDrawableRes$default(this, 2130970089, 0, 2, (Object) null)));
            }
            Toolbar toolbar3 = this.toolbar;
            if (toolbar3 != null) {
                toolbar3.setNavigationOnClickListener(new AppActivity$g(this));
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppActivity$a appActivity$a = new AppActivity$a(0, this);
        AppActivity$a appActivity$a2 = new AppActivity$a(1, this);
        try {
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            String theme = storeStream$Companion.getUserSettingsSystem().getTheme();
            int i = 2131951650;
            if (m.areEqual(theme, ModelUserSettings.THEME_LIGHT)) {
                i = 2131951657;
            } else if (!m.areEqual(theme, ModelUserSettings.THEME_DARK) && m.areEqual(theme, ModelUserSettings.THEME_PURE_EVIL)) {
                i = 2131951652;
            }
            setTheme(i);
            b(storeStream$Companion.getUserSettingsSystem().getLocale(), false);
            appActivity$a.invoke2();
            appActivity$a2.invoke2();
            if (h(a0.getOrCreateKotlinClass(WidgetTabsHost.class)) && storeStream$Companion.getTabsNavigation().getSelectedTab() == NavigationTab.HOME) {
                return;
            }
            storeStream$Companion.getAnalytics().appUiViewed(d());
        } catch (Exception e) {
            if (!h(a0.getOrCreateKotlinClass(WidgetFatalCrash.class))) {
                WidgetFatalCrash$Companion widgetFatalCrash$Companion = WidgetFatalCrash.Companion;
                String name = d().getName();
                m.checkNotNullExpressionValue(name, "screen.name");
                widgetFatalCrash$Companion.launch(this, e, name);
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
        Iterator<Map$Entry<Integer, Function1<Intent, Unit>>> it = this.newIntentListeners.entrySet().iterator();
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
        j jVar = j.g;
        m.checkNotNullParameter(this, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        boolean booleanExtra = c().getBooleanExtra("INTENT_RECREATE", false);
        if (booleanExtra) {
            c().removeExtra("INTENT_RECREATE");
            new Handler(Looper.getMainLooper()).post(new i(this));
        }
        if (booleanExtra) {
            return;
        }
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        if ((!m.areEqual(storeStream$Companion.getUserSettingsSystem().getLocale(), this.originalLocale)) && (!m.areEqual(this.originalLocale, ""))) {
            i(this, false, 1, null);
            return;
        }
        this.originalLocale = storeStream$Companion.getUserSettingsSystem().getLocale();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(storeStream$Companion.getUserSettingsSystem().observeSettings(true), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AppActivity$c(this), 62, (Object) null);
        ScreenshotDetector screenshotDetector = ScreenshotDetector.a;
        if (screenshotDetector == null) {
            m.throwUninitializedPropertyAccessException("screenshotDetector");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(screenshotDetector.publishSubject, this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AppActivity$d(this), 62, (Object) null);
    }

    public final void showKeyboard(View view) {
        m.checkNotNullParameter(view, "view");
        m(true, view);
    }
}
