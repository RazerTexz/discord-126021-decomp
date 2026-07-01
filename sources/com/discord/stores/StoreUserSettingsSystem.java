package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences$Editor;
import android.content.res.Resources;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.models.domain.auth.ModelUserSettingsBootstrap;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.cache.SharedPreferenceExtensionsKt;
import d0.z.d.m;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StoreUserSettingsSystem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserSettingsSystem extends StoreV2 {
    public static final StoreUserSettingsSystem$Companion Companion = new StoreUserSettingsSystem$Companion(null);
    private static final boolean DEFAULT_IS_CLIENT_SYNC_ENABLED = true;
    private final Dispatcher dispatcher;
    private final Function1<Integer, Unit> onFontScaleUpdated;
    private StoreUserSettingsSystem$Settings settings;

    /* JADX WARN: Multi-variable type inference failed */
    public StoreUserSettingsSystem(Function1<? super Integer, Unit> function1, Dispatcher dispatcher) {
        m.checkNotNullParameter(function1, "onFontScaleUpdated");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.onFontScaleUpdated = function1;
        this.dispatcher = dispatcher;
    }

    public static final /* synthetic */ Function1 access$getOnFontScaleUpdated$p(StoreUserSettingsSystem storeUserSettingsSystem) {
        return storeUserSettingsSystem.onFontScaleUpdated;
    }

    public static final /* synthetic */ StoreUserSettingsSystem$Settings access$getSettings$p(StoreUserSettingsSystem storeUserSettingsSystem) {
        StoreUserSettingsSystem$Settings storeUserSettingsSystem$Settings = storeUserSettingsSystem.settings;
        if (storeUserSettingsSystem$Settings == null) {
            m.throwUninitializedPropertyAccessException("settings");
        }
        return storeUserSettingsSystem$Settings;
    }

    public static final /* synthetic */ void access$setSettings$p(StoreUserSettingsSystem storeUserSettingsSystem, StoreUserSettingsSystem$Settings storeUserSettingsSystem$Settings) {
        storeUserSettingsSystem.settings = storeUserSettingsSystem$Settings;
    }

    public static final /* synthetic */ void access$setThemeInternal(StoreUserSettingsSystem storeUserSettingsSystem, String str, boolean z2, Function0 function0) {
        storeUserSettingsSystem.setThemeInternal(str, z2, function0);
    }

    @StoreThread
    private final void handleUserSettings(ModelUserSettings userSettings) {
        handleUserSettingsThemeUpdate(userSettings.getTheme());
        handleUserSettingsLocaleUpdate(userSettings.getLocale());
    }

    private final void handleUserSettingsLocaleUpdate(String locale) {
        if (locale == null || !getIsLocaleSyncEnabled()) {
            return;
        }
        setLocale$default(this, locale, false, null, 4, null);
    }

    @StoreThread
    private final void handleUserSettingsThemeUpdate(String theme) {
        if (theme == null || !getIsThemeSyncEnabled()) {
            return;
        }
        setThemeInternal$default(this, theme, false, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setLocale$default(StoreUserSettingsSystem storeUserSettingsSystem, String str, boolean z2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        storeUserSettingsSystem.setLocale(str, z2, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setTheme$default(StoreUserSettingsSystem storeUserSettingsSystem, String str, boolean z2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        storeUserSettingsSystem.setTheme(str, z2, function0);
    }

    @StoreThread
    private final void setThemeInternal(String theme, boolean apiSync, Function0<Unit> onRequestApiSync) {
        if (getIsThemeSyncEnabled() && apiSync && (onRequestApiSync == null || onRequestApiSync.invoke() == null)) {
            throw new IllegalArgumentException("API callback required.");
        }
        if (m.areEqual(getTheme(), ModelUserSettings.THEME_PURE_EVIL) && m.areEqual(theme, ModelUserSettings.THEME_DARK)) {
            theme = ModelUserSettings.THEME_PURE_EVIL;
        }
        StoreUserSettingsSystem$Settings storeUserSettingsSystem$Settings = this.settings;
        if (storeUserSettingsSystem$Settings == null) {
            m.throwUninitializedPropertyAccessException("settings");
        }
        this.settings = StoreUserSettingsSystem$Settings.copy$default(storeUserSettingsSystem$Settings, theme, null, 0, 6, null);
        SharedPreferences$Editor sharedPreferences$EditorEdit = getPrefsSessionDurable().edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putString("CACHE_KEY_THEME", theme);
        sharedPreferences$EditorEdit.apply();
        markChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setThemeInternal$default(StoreUserSettingsSystem storeUserSettingsSystem, String str, boolean z2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        storeUserSettingsSystem.setThemeInternal(str, z2, function0);
    }

    public final int getFontScale() {
        StoreUserSettingsSystem$Settings storeUserSettingsSystem$Settings = this.settings;
        if (storeUserSettingsSystem$Settings == null) {
            m.throwUninitializedPropertyAccessException("settings");
        }
        return storeUserSettingsSystem$Settings.getFontScale();
    }

    public final boolean getIsLocaleSyncEnabled() {
        return getPrefs().getBoolean("CACHE_KEY_LOCALE_SYNC", true);
    }

    public final boolean getIsThemeSyncEnabled() {
        return getPrefsSessionDurable().getBoolean("CACHE_KEY_THEME_SYNC", true);
    }

    public final String getLocale() {
        StoreUserSettingsSystem$Settings storeUserSettingsSystem$Settings = this.settings;
        if (storeUserSettingsSystem$Settings == null) {
            m.throwUninitializedPropertyAccessException("settings");
        }
        return storeUserSettingsSystem$Settings.getLocale();
    }

    public final String getTheme() {
        StoreUserSettingsSystem$Settings storeUserSettingsSystem$Settings = this.settings;
        if (storeUserSettingsSystem$Settings == null) {
            m.throwUninitializedPropertyAccessException("settings");
        }
        return storeUserSettingsSystem$Settings.getTheme();
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        ModelUserSettings userSettings = payload.getUserSettings();
        m.checkNotNullExpressionValue(userSettings, "payload.userSettings");
        handleUserSettings(userSettings);
    }

    @StoreThread
    public final void handleLoginResult(ModelLoginResult loginResult) {
        m.checkNotNullParameter(loginResult, "loginResult");
        ModelUserSettingsBootstrap userSettings = loginResult.getUserSettings();
        handleUserSettingsThemeUpdate(userSettings != null ? userSettings.getTheme() : null);
        ModelUserSettingsBootstrap userSettings2 = loginResult.getUserSettings();
        handleUserSettingsLocaleUpdate(userSettings2 != null ? userSettings2.getLocale() : null);
    }

    @StoreThread
    public final void handlePreLogout() {
        setIsSyncThemeEnabled(true);
        setIsLocaleSyncEnabled(true);
        setLocale$default(this, null, false, null, 4, null);
        setFontScale(-1);
    }

    @StoreThread
    public final void handleUserSettingsUpdate(ModelUserSettings userSettings) {
        m.checkNotNullParameter(userSettings, "userSettings");
        handleUserSettings(userSettings);
    }

    @Override // com.discord.stores.Store
    @StoreThread
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        Resources resources = context.getResources();
        m.checkNotNullExpressionValue(resources, "context.resources");
        this.settings = new StoreUserSettingsSystem$Settings(SharedPreferenceExtensionsKt.getStringNonNull(getPrefsSessionDurable(), "CACHE_KEY_THEME", (resources.getConfiguration().uiMode & 48) != 32 ? ModelUserSettings.THEME_LIGHT : ModelUserSettings.THEME_DARK), getPrefs().getString("CACHE_KEY_LOCALE", null), getPrefs().getInt("CACHE_KEY_FONT_SCALE", -1));
    }

    public final Observable<StoreUserSettingsSystem$Settings> observeSettings(boolean sample) {
        Observable observableConnectRx$default = ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreUserSettingsSystem$observeSettings$1(this), 14, null);
        if (sample) {
            observableConnectRx$default = observableConnectRx$default.P(1500L, TimeUnit.MILLISECONDS);
        }
        Observable<StoreUserSettingsSystem$Settings> observableR = observableConnectRx$default.r();
        m.checkNotNullExpressionValue(observableR, "ObservationDeckProvider\n…  .distinctUntilChanged()");
        return observableR;
    }

    public final void setFontScale(int fontScale) {
        SharedPreferences$Editor sharedPreferences$EditorEdit = getPrefs().edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putInt("CACHE_KEY_FONT_SCALE", fontScale);
        sharedPreferences$EditorEdit.apply();
        this.dispatcher.schedule(new StoreUserSettingsSystem$setFontScale$2(this, fontScale));
    }

    public final void setIsLocaleSyncEnabled(boolean isLocaleSyncEnabled) {
        SharedPreferences$Editor sharedPreferences$EditorEdit = getPrefs().edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putBoolean("CACHE_KEY_LOCALE_SYNC", isLocaleSyncEnabled);
        sharedPreferences$EditorEdit.apply();
    }

    public final void setIsSyncThemeEnabled(boolean isSyncThemeEnabled) {
        SharedPreferences$Editor sharedPreferences$EditorEdit = getPrefsSessionDurable().edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putBoolean("CACHE_KEY_THEME_SYNC", isSyncThemeEnabled);
        sharedPreferences$EditorEdit.apply();
    }

    public final void setLocale(String locale, boolean apiSync, Function0<Unit> onRequestApiSync) {
        if (getIsLocaleSyncEnabled() && apiSync && (onRequestApiSync == null || onRequestApiSync.invoke() == null)) {
            throw new IllegalArgumentException("API callback required.");
        }
        StoreUserSettingsSystem$Settings storeUserSettingsSystem$Settings = this.settings;
        if (storeUserSettingsSystem$Settings == null) {
            m.throwUninitializedPropertyAccessException("settings");
        }
        this.settings = StoreUserSettingsSystem$Settings.copy$default(storeUserSettingsSystem$Settings, null, locale, 0, 5, null);
        SharedPreferences$Editor sharedPreferences$EditorEdit = getPrefs().edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putString("CACHE_KEY_LOCALE", locale);
        sharedPreferences$EditorEdit.apply();
        markChanged();
    }

    public final void setTheme(String theme, boolean apiSync, Function0<Unit> onRequestApiSync) {
        m.checkNotNullParameter(theme, "theme");
        this.dispatcher.schedule(new StoreUserSettingsSystem$setTheme$1(this, theme, apiSync, onRequestApiSync));
    }
}
