package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import b.d.b.a.outline;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.models.domain.auth.ModelLoginResult2;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.cache.SharedPreferenceExtensions;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StoreUserSettingsSystem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserSettingsSystem extends StoreV2 {
    private static final boolean DEFAULT_IS_CLIENT_SYNC_ENABLED = true;
    private final Dispatcher dispatcher;
    private final Function1<Integer, Unit> onFontScaleUpdated;
    private Settings settings;

    /* JADX INFO: compiled from: StoreUserSettingsSystem.kt */
    public static final /* data */ class Settings {
        private final String _locale;
        private final int fontScale;
        private final String theme;

        public Settings(String str, String str2, int i) {
            Intrinsics3.checkNotNullParameter(str, "theme");
            this.theme = str;
            this._locale = str2;
            this.fontScale = i;
        }

        public static /* synthetic */ Settings copy$default(Settings settings, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = settings.theme;
            }
            if ((i2 & 2) != 0) {
                str2 = settings._locale;
            }
            if ((i2 & 4) != 0) {
                i = settings.fontScale;
            }
            return settings.copy(str, str2, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTheme() {
            return this.theme;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String get_locale() {
            return this._locale;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getFontScale() {
            return this.fontScale;
        }

        public final Settings copy(String theme, String _locale, int fontScale) {
            Intrinsics3.checkNotNullParameter(theme, "theme");
            return new Settings(theme, _locale, fontScale);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Settings)) {
                return false;
            }
            Settings settings = (Settings) other;
            return Intrinsics3.areEqual(this.theme, settings.theme) && Intrinsics3.areEqual(this._locale, settings._locale) && this.fontScale == settings.fontScale;
        }

        public final int getFontScale() {
            return this.fontScale;
        }

        public final String getLocale() {
            String str = this._locale;
            if (str != null) {
                return str;
            }
            String defaultLocale = ModelUserSettings.getDefaultLocale();
            Intrinsics3.checkNotNullExpressionValue(defaultLocale, "ModelUserSettings.getDefaultLocale()");
            return defaultLocale;
        }

        public final String getTheme() {
            return this.theme;
        }

        public final String get_locale() {
            return this._locale;
        }

        public int hashCode() {
            String str = this.theme;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this._locale;
            return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.fontScale;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Settings(theme=");
            sbU.append(this.theme);
            sbU.append(", _locale=");
            sbU.append(this._locale);
            sbU.append(", fontScale=");
            return outline.B(sbU, this.fontScale, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserSettingsSystem$observeSettings$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserSettingsSystem.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Settings> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Settings invoke() {
            return StoreUserSettingsSystem.access$getSettings$p(StoreUserSettingsSystem.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserSettingsSystem$setFontScale$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserSettingsSystem.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int $fontScale;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i) {
            super(0);
            this.$fontScale = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreUserSettingsSystem storeUserSettingsSystem = StoreUserSettingsSystem.this;
            storeUserSettingsSystem.settings = Settings.copy$default(StoreUserSettingsSystem.access$getSettings$p(storeUserSettingsSystem), null, null, this.$fontScale, 3, null);
            StoreUserSettingsSystem.this.markChanged();
            StoreUserSettingsSystem.this.onFontScaleUpdated.invoke(Integer.valueOf(this.$fontScale));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserSettingsSystem$setTheme$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserSettingsSystem.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $apiSync;
        public final /* synthetic */ Function0 $onRequestApiSync;
        public final /* synthetic */ String $theme;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, boolean z2, Function0 function0) {
            super(0);
            this.$theme = str;
            this.$apiSync = z2;
            this.$onRequestApiSync = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreUserSettingsSystem.this.setThemeInternal(this.$theme, this.$apiSync, this.$onRequestApiSync);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreUserSettingsSystem(Function1<? super Integer, Unit> function1, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(function1, "onFontScaleUpdated");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.onFontScaleUpdated = function1;
        this.dispatcher = dispatcher;
    }

    public static final /* synthetic */ Settings access$getSettings$p(StoreUserSettingsSystem storeUserSettingsSystem) {
        Settings settings = storeUserSettingsSystem.settings;
        if (settings == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("settings");
        }
        return settings;
    }

    @Store3
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

    @Store3
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

    @Store3
    private final void setThemeInternal(String theme, boolean apiSync, Function0<Unit> onRequestApiSync) {
        if (getIsThemeSyncEnabled() && apiSync && (onRequestApiSync == null || onRequestApiSync.invoke() == null)) {
            throw new IllegalArgumentException("API callback required.");
        }
        if (Intrinsics3.areEqual(getTheme(), ModelUserSettings.THEME_PURE_EVIL) && Intrinsics3.areEqual(theme, ModelUserSettings.THEME_DARK)) {
            theme = ModelUserSettings.THEME_PURE_EVIL;
        }
        Settings settings = this.settings;
        if (settings == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("settings");
        }
        this.settings = Settings.copy$default(settings, theme, null, 0, 6, null);
        SharedPreferences.Editor editorEdit = getPrefsSessionDurable().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putString("CACHE_KEY_THEME", theme);
        editorEdit.apply();
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
        Settings settings = this.settings;
        if (settings == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("settings");
        }
        return settings.getFontScale();
    }

    public final boolean getIsLocaleSyncEnabled() {
        return getPrefs().getBoolean("CACHE_KEY_LOCALE_SYNC", true);
    }

    public final boolean getIsThemeSyncEnabled() {
        return getPrefsSessionDurable().getBoolean("CACHE_KEY_THEME_SYNC", true);
    }

    public final String getLocale() {
        Settings settings = this.settings;
        if (settings == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("settings");
        }
        return settings.getLocale();
    }

    public final String getTheme() {
        Settings settings = this.settings;
        if (settings == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("settings");
        }
        return settings.getTheme();
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        ModelUserSettings userSettings = payload.getUserSettings();
        Intrinsics3.checkNotNullExpressionValue(userSettings, "payload.userSettings");
        handleUserSettings(userSettings);
    }

    @Store3
    public final void handleLoginResult(ModelLoginResult loginResult) {
        Intrinsics3.checkNotNullParameter(loginResult, "loginResult");
        ModelLoginResult2 userSettings = loginResult.getUserSettings();
        handleUserSettingsThemeUpdate(userSettings != null ? userSettings.getTheme() : null);
        ModelLoginResult2 userSettings2 = loginResult.getUserSettings();
        handleUserSettingsLocaleUpdate(userSettings2 != null ? userSettings2.getLocale() : null);
    }

    @Store3
    public final void handlePreLogout() {
        setIsSyncThemeEnabled(true);
        setIsLocaleSyncEnabled(true);
        setLocale$default(this, null, false, null, 4, null);
        setFontScale(-1);
    }

    @Store3
    public final void handleUserSettingsUpdate(ModelUserSettings userSettings) {
        Intrinsics3.checkNotNullParameter(userSettings, "userSettings");
        handleUserSettings(userSettings);
    }

    @Override // com.discord.stores.Store
    @Store3
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        Resources resources = context.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
        this.settings = new Settings(SharedPreferenceExtensions.getStringNonNull(getPrefsSessionDurable(), "CACHE_KEY_THEME", (resources.getConfiguration().uiMode & 48) != 32 ? ModelUserSettings.THEME_LIGHT : ModelUserSettings.THEME_DARK), getPrefs().getString("CACHE_KEY_LOCALE", null), getPrefs().getInt("CACHE_KEY_FONT_SCALE", -1));
    }

    public final Observable<Settings> observeSettings(boolean sample) {
        Observable observableConnectRx$default = ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
        if (sample) {
            observableConnectRx$default = observableConnectRx$default.P(1500L, TimeUnit.MILLISECONDS);
        }
        Observable<Settings> observableR = observableConnectRx$default.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "ObservationDeckProvider\n…  .distinctUntilChanged()");
        return observableR;
    }

    public final void setFontScale(int fontScale) {
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putInt("CACHE_KEY_FONT_SCALE", fontScale);
        editorEdit.apply();
        this.dispatcher.schedule(new AnonymousClass2(fontScale));
    }

    public final void setIsLocaleSyncEnabled(boolean isLocaleSyncEnabled) {
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean("CACHE_KEY_LOCALE_SYNC", isLocaleSyncEnabled);
        editorEdit.apply();
    }

    public final void setIsSyncThemeEnabled(boolean isSyncThemeEnabled) {
        SharedPreferences.Editor editorEdit = getPrefsSessionDurable().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean("CACHE_KEY_THEME_SYNC", isSyncThemeEnabled);
        editorEdit.apply();
    }

    public final void setLocale(String locale, boolean apiSync, Function0<Unit> onRequestApiSync) {
        if (getIsLocaleSyncEnabled() && apiSync && (onRequestApiSync == null || onRequestApiSync.invoke() == null)) {
            throw new IllegalArgumentException("API callback required.");
        }
        Settings settings = this.settings;
        if (settings == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("settings");
        }
        this.settings = Settings.copy$default(settings, null, locale, 0, 5, null);
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putString("CACHE_KEY_LOCALE", locale);
        editorEdit.apply();
        markChanged();
    }

    public final void setTheme(String theme, boolean apiSync, Function0<Unit> onRequestApiSync) {
        Intrinsics3.checkNotNullParameter(theme, "theme");
        this.dispatcher.schedule(new AnonymousClass1(theme, apiSync, onRequestApiSync));
    }
}
