package androidx.appcompat.app;

import android.R$attr;
import android.R$id;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources$Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater$Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window$Callback;
import android.view.WindowManager;
import android.view.WindowManager$LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout$LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R$color;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode$Callback;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat$ThemeCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.KeyEventDispatcher$Component;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.PopupWindowCompat;
import androidx.view.Lifecycle$State;
import androidx.view.LifecycleOwner;
import b.d.b.a.a;
import org.objectweb.asm.Opcodes;
import org.webrtc.MediaStreamTrack;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY})
public class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder$Callback, LayoutInflater$Factory2 {
    public static final String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
    private static boolean sInstalledExceptionHandler;
    public ActionBar mActionBar;
    private AppCompatDelegateImpl$ActionMenuPresenterCallback mActionMenuPresenterCallback;
    public ActionMode mActionMode;
    public PopupWindow mActionModePopup;
    public ActionBarContextView mActionModeView;
    private boolean mActivityHandlesUiMode;
    private boolean mActivityHandlesUiModeChecked;
    public final AppCompatCallback mAppCompatCallback;
    private AppCompatViewInflater mAppCompatViewInflater;
    private AppCompatDelegateImpl$AppCompatWindowCallback mAppCompatWindowCallback;
    private AppCompatDelegateImpl$AutoNightModeManager mAutoBatteryNightModeManager;
    private AppCompatDelegateImpl$AutoNightModeManager mAutoTimeNightModeManager;
    private boolean mBaseContextAttached;
    private boolean mClosingActionMenu;
    public final Context mContext;
    private boolean mCreated;
    private DecorContentParent mDecorContentParent;
    private boolean mEnableDefaultActionBarUp;
    public ViewPropertyAnimatorCompat mFadeAnim;
    private boolean mFeatureIndeterminateProgress;
    private boolean mFeatureProgress;
    private boolean mHandleNativeActionModes;
    public boolean mHasActionBar;
    public final Object mHost;
    public int mInvalidatePanelMenuFeatures;
    public boolean mInvalidatePanelMenuPosted;
    private final Runnable mInvalidatePanelMenuRunnable;
    public boolean mIsDestroyed;
    public boolean mIsFloating;
    private int mLocalNightMode;
    private boolean mLongPressBackDown;
    public MenuInflater mMenuInflater;
    public boolean mOverlayActionBar;
    public boolean mOverlayActionMode;
    private AppCompatDelegateImpl$PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    private AppCompatDelegateImpl$PanelFeatureState[] mPanels;
    private AppCompatDelegateImpl$PanelFeatureState mPreparedPanel;
    public Runnable mShowActionModePopup;
    private boolean mStarted;
    private View mStatusGuard;
    public ViewGroup mSubDecor;
    private boolean mSubDecorInstalled;
    private Rect mTempRect1;
    private Rect mTempRect2;
    private int mThemeResId;
    private CharSequence mTitle;
    private TextView mTitleView;
    public Window mWindow;
    public boolean mWindowNoTitle;
    private static final SimpleArrayMap<String, Integer> sLocalNightModes = new SimpleArrayMap<>();
    private static final boolean IS_PRE_LOLLIPOP = false;
    private static final int[] sWindowBackgroundStyleable = {R$attr.windowBackground};
    private static final boolean sCanReturnDifferentContext = !"robolectric".equals(Build.FINGERPRINT);
    private static final boolean sCanApplyOverrideConfiguration = true;

    public AppCompatDelegateImpl(Activity activity, AppCompatCallback appCompatCallback) {
        this(activity, null, appCompatCallback, activity);
    }

    private void applyFixedSizeWindow() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.mSubDecor.findViewById(R$id.content);
        View decorView = this.mWindow.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.mContext.obtainStyledAttributes(R$styleable.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        int i = R$styleable.AppCompatTheme_windowFixedWidthMajor;
        if (typedArrayObtainStyledAttributes.hasValue(i)) {
            typedArrayObtainStyledAttributes.getValue(i, contentFrameLayout.getFixedWidthMajor());
        }
        int i2 = R$styleable.AppCompatTheme_windowFixedWidthMinor;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            typedArrayObtainStyledAttributes.getValue(i2, contentFrameLayout.getFixedWidthMinor());
        }
        int i3 = R$styleable.AppCompatTheme_windowFixedHeightMajor;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            typedArrayObtainStyledAttributes.getValue(i3, contentFrameLayout.getFixedHeightMajor());
        }
        int i4 = R$styleable.AppCompatTheme_windowFixedHeightMinor;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            typedArrayObtainStyledAttributes.getValue(i4, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void attachToWindow(@NonNull Window window) {
        if (this.mWindow != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window$Callback callback = window.getCallback();
        if (callback instanceof AppCompatDelegateImpl$AppCompatWindowCallback) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        AppCompatDelegateImpl$AppCompatWindowCallback appCompatDelegateImpl$AppCompatWindowCallback = new AppCompatDelegateImpl$AppCompatWindowCallback(this, callback);
        this.mAppCompatWindowCallback = appCompatDelegateImpl$AppCompatWindowCallback;
        window.setCallback(appCompatDelegateImpl$AppCompatWindowCallback);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mContext, (AttributeSet) null, sWindowBackgroundStyleable);
        Drawable drawableIfKnown = tintTypedArrayObtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            window.setBackgroundDrawable(drawableIfKnown);
        }
        tintTypedArrayObtainStyledAttributes.recycle();
        this.mWindow = window;
    }

    private int calculateNightMode() {
        int i = this.mLocalNightMode;
        return i != -100 ? i : AppCompatDelegate.getDefaultNightMode();
    }

    private void cleanupAutoManagers() {
        AppCompatDelegateImpl$AutoNightModeManager appCompatDelegateImpl$AutoNightModeManager = this.mAutoTimeNightModeManager;
        if (appCompatDelegateImpl$AutoNightModeManager != null) {
            appCompatDelegateImpl$AutoNightModeManager.cleanup();
        }
        AppCompatDelegateImpl$AutoNightModeManager appCompatDelegateImpl$AutoNightModeManager2 = this.mAutoBatteryNightModeManager;
        if (appCompatDelegateImpl$AutoNightModeManager2 != null) {
            appCompatDelegateImpl$AutoNightModeManager2.cleanup();
        }
    }

    @NonNull
    private Configuration createOverrideConfigurationForDayNight(@NonNull Context context, int i, @Nullable Configuration configuration) {
        int i2;
        if (i != 1) {
            i2 = i != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32;
        } else {
            i2 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    private ViewGroup createSubDecor() {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.mContext.obtainStyledAttributes(R$styleable.AppCompatTheme);
        int i = R$styleable.AppCompatTheme_windowActionBar;
        if (!typedArrayObtainStyledAttributes.hasValue(i)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
            requestWindowFeature(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(i, false)) {
            requestWindowFeature(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            requestWindowFeature(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            requestWindowFeature(10);
        }
        this.mIsFloating = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        ensureWindow();
        this.mWindow.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.mContext);
        if (this.mWindowNoTitle) {
            viewGroup = this.mOverlayActionMode ? (ViewGroup) layoutInflaterFrom.inflate(R$layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(R$layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.mIsFloating) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
            this.mOverlayActionBar = false;
            this.mHasActionBar = false;
        } else if (this.mHasActionBar) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(androidx.appcompat.R$attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new ContextThemeWrapper(this.mContext, typedValue.resourceId) : this.mContext).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
            DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(androidx.appcompat.R$id.decor_content_parent);
            this.mDecorContentParent = decorContentParent;
            decorContentParent.setWindowCallback(getWindowCallback());
            if (this.mOverlayActionBar) {
                this.mDecorContentParent.initFeature(109);
            }
            if (this.mFeatureProgress) {
                this.mDecorContentParent.initFeature(2);
            }
            if (this.mFeatureIndeterminateProgress) {
                this.mDecorContentParent.initFeature(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            StringBuilder sbU = a.U("AppCompat does not support the current theme features: { windowActionBar: ");
            sbU.append(this.mHasActionBar);
            sbU.append(", windowActionBarOverlay: ");
            sbU.append(this.mOverlayActionBar);
            sbU.append(", android:windowIsFloating: ");
            sbU.append(this.mIsFloating);
            sbU.append(", windowActionModeOverlay: ");
            sbU.append(this.mOverlayActionMode);
            sbU.append(", windowNoTitle: ");
            throw new IllegalArgumentException(a.O(sbU, this.mWindowNoTitle, " }"));
        }
        ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new AppCompatDelegateImpl$3(this));
        if (this.mDecorContentParent == null) {
            this.mTitleView = (TextView) viewGroup.findViewById(androidx.appcompat.R$id.title);
        }
        ViewUtils.makeOptionalFitsSystemWindows(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(androidx.appcompat.R$id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.mWindow.findViewById(R$id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R$id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.mWindow.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new AppCompatDelegateImpl$5(this));
        return viewGroup;
    }

    private void ensureSubDecor() {
        if (this.mSubDecorInstalled) {
            return;
        }
        this.mSubDecor = createSubDecor();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            DecorContentParent decorContentParent = this.mDecorContentParent;
            if (decorContentParent != null) {
                decorContentParent.setWindowTitle(title);
            } else if (peekSupportActionBar() != null) {
                peekSupportActionBar().setWindowTitle(title);
            } else {
                TextView textView = this.mTitleView;
                if (textView != null) {
                    textView.setText(title);
                }
            }
        }
        applyFixedSizeWindow();
        onSubDecorInstalled(this.mSubDecor);
        this.mSubDecorInstalled = true;
        AppCompatDelegateImpl$PanelFeatureState panelState = getPanelState(0, false);
        if (this.mIsDestroyed) {
            return;
        }
        if (panelState == null || panelState.menu == null) {
            invalidatePanelMenu(108);
        }
    }

    private void ensureWindow() {
        if (this.mWindow == null) {
            Object obj = this.mHost;
            if (obj instanceof Activity) {
                attachToWindow(((Activity) obj).getWindow());
            }
        }
        if (this.mWindow == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    @NonNull
    private static Configuration generateConfigDelta(@NonNull Configuration configuration, @Nullable Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f = configuration.fontScale;
            float f2 = configuration2.fontScale;
            if (f != f2) {
                configuration3.fontScale = f2;
            }
            int i = configuration.mcc;
            int i2 = configuration2.mcc;
            if (i != i2) {
                configuration3.mcc = i2;
            }
            int i3 = configuration.mnc;
            int i4 = configuration2.mnc;
            if (i3 != i4) {
                configuration3.mnc = i4;
            }
            int i5 = Build$VERSION.SDK_INT;
            if (i5 >= 24) {
                AppCompatDelegateImpl$ConfigurationImplApi24.generateConfigDelta_locale(configuration, configuration2, configuration3);
            } else if (!ObjectsCompat.equals(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i6 = configuration.touchscreen;
            int i7 = configuration2.touchscreen;
            if (i6 != i7) {
                configuration3.touchscreen = i7;
            }
            int i8 = configuration.keyboard;
            int i9 = configuration2.keyboard;
            if (i8 != i9) {
                configuration3.keyboard = i9;
            }
            int i10 = configuration.keyboardHidden;
            int i11 = configuration2.keyboardHidden;
            if (i10 != i11) {
                configuration3.keyboardHidden = i11;
            }
            int i12 = configuration.navigation;
            int i13 = configuration2.navigation;
            if (i12 != i13) {
                configuration3.navigation = i13;
            }
            int i14 = configuration.navigationHidden;
            int i15 = configuration2.navigationHidden;
            if (i14 != i15) {
                configuration3.navigationHidden = i15;
            }
            int i16 = configuration.orientation;
            int i17 = configuration2.orientation;
            if (i16 != i17) {
                configuration3.orientation = i17;
            }
            int i18 = configuration.screenLayout & 15;
            int i19 = configuration2.screenLayout;
            if (i18 != (i19 & 15)) {
                configuration3.screenLayout |= i19 & 15;
            }
            int i20 = configuration.screenLayout & Opcodes.CHECKCAST;
            int i21 = configuration2.screenLayout;
            if (i20 != (i21 & Opcodes.CHECKCAST)) {
                configuration3.screenLayout |= i21 & Opcodes.CHECKCAST;
            }
            int i22 = configuration.screenLayout & 48;
            int i23 = configuration2.screenLayout;
            if (i22 != (i23 & 48)) {
                configuration3.screenLayout |= i23 & 48;
            }
            int i24 = configuration.screenLayout & 768;
            int i25 = configuration2.screenLayout;
            if (i24 != (i25 & 768)) {
                configuration3.screenLayout |= i25 & 768;
            }
            if (i5 >= 26) {
                AppCompatDelegateImpl$ConfigurationImplApi26.generateConfigDelta_colorMode(configuration, configuration2, configuration3);
            }
            int i26 = configuration.uiMode & 15;
            int i27 = configuration2.uiMode;
            if (i26 != (i27 & 15)) {
                configuration3.uiMode |= i27 & 15;
            }
            int i28 = configuration.uiMode & 48;
            int i29 = configuration2.uiMode;
            if (i28 != (i29 & 48)) {
                configuration3.uiMode |= i29 & 48;
            }
            int i30 = configuration.screenWidthDp;
            int i31 = configuration2.screenWidthDp;
            if (i30 != i31) {
                configuration3.screenWidthDp = i31;
            }
            int i32 = configuration.screenHeightDp;
            int i33 = configuration2.screenHeightDp;
            if (i32 != i33) {
                configuration3.screenHeightDp = i33;
            }
            int i34 = configuration.smallestScreenWidthDp;
            int i35 = configuration2.smallestScreenWidthDp;
            if (i34 != i35) {
                configuration3.smallestScreenWidthDp = i35;
            }
            AppCompatDelegateImpl$ConfigurationImplApi17.generateConfigDelta_densityDpi(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    private AppCompatDelegateImpl$AutoNightModeManager getAutoBatteryNightModeManager(@NonNull Context context) {
        if (this.mAutoBatteryNightModeManager == null) {
            this.mAutoBatteryNightModeManager = new AppCompatDelegateImpl$AutoBatteryNightModeManager(this, context);
        }
        return this.mAutoBatteryNightModeManager;
    }

    private void initWindowDecorActionBar() {
        ensureSubDecor();
        if (this.mHasActionBar && this.mActionBar == null) {
            Object obj = this.mHost;
            if (obj instanceof Activity) {
                this.mActionBar = new WindowDecorActionBar((Activity) this.mHost, this.mOverlayActionBar);
            } else if (obj instanceof Dialog) {
                this.mActionBar = new WindowDecorActionBar((Dialog) this.mHost);
            }
            ActionBar actionBar = this.mActionBar;
            if (actionBar != null) {
                actionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
            }
        }
    }

    private boolean initializePanelContent(AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState) {
        View view = appCompatDelegateImpl$PanelFeatureState.createdPanelView;
        if (view != null) {
            appCompatDelegateImpl$PanelFeatureState.shownPanelView = view;
            return true;
        }
        if (appCompatDelegateImpl$PanelFeatureState.menu == null) {
            return false;
        }
        if (this.mPanelMenuPresenterCallback == null) {
            this.mPanelMenuPresenterCallback = new AppCompatDelegateImpl$PanelMenuPresenterCallback(this);
        }
        View view2 = (View) appCompatDelegateImpl$PanelFeatureState.getListMenuView(this.mPanelMenuPresenterCallback);
        appCompatDelegateImpl$PanelFeatureState.shownPanelView = view2;
        return view2 != null;
    }

    private boolean initializePanelDecor(AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState) {
        appCompatDelegateImpl$PanelFeatureState.setStyle(getActionBarThemedContext());
        appCompatDelegateImpl$PanelFeatureState.decorView = new AppCompatDelegateImpl$ListMenuDecorView(this, appCompatDelegateImpl$PanelFeatureState.listPresenterContext);
        appCompatDelegateImpl$PanelFeatureState.gravity = 81;
        return true;
    }

    private boolean initializePanelMenu(AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState) {
        Context context = this.mContext;
        int i = appCompatDelegateImpl$PanelFeatureState.featureId;
        if ((i == 0 || i == 108) && this.mDecorContentParent != null) {
            TypedValue typedValue = new TypedValue();
            Resources$Theme theme = context.getTheme();
            theme.resolveAttribute(androidx.appcompat.R$attr.actionBarTheme, typedValue, true);
            Resources$Theme resources$ThemeNewTheme = null;
            if (typedValue.resourceId != 0) {
                resources$ThemeNewTheme = context.getResources().newTheme();
                resources$ThemeNewTheme.setTo(theme);
                resources$ThemeNewTheme.applyStyle(typedValue.resourceId, true);
                resources$ThemeNewTheme.resolveAttribute(androidx.appcompat.R$attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(androidx.appcompat.R$attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (resources$ThemeNewTheme == null) {
                    resources$ThemeNewTheme = context.getResources().newTheme();
                    resources$ThemeNewTheme.setTo(theme);
                }
                resources$ThemeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (resources$ThemeNewTheme != null) {
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(resources$ThemeNewTheme);
                context = contextThemeWrapper;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.setCallback(this);
        appCompatDelegateImpl$PanelFeatureState.setMenu(menuBuilder);
        return true;
    }

    private void invalidatePanelMenu(int i) {
        this.mInvalidatePanelMenuFeatures = (1 << i) | this.mInvalidatePanelMenuFeatures;
        if (this.mInvalidatePanelMenuPosted) {
            return;
        }
        ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
        this.mInvalidatePanelMenuPosted = true;
    }

    private boolean isActivityManifestHandlingUiMode() {
        int i;
        if (!this.mActivityHandlesUiModeChecked && (this.mHost instanceof Activity)) {
            PackageManager packageManager = this.mContext.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                int i2 = Build$VERSION.SDK_INT;
                if (i2 >= 29) {
                    i = 269221888;
                } else {
                    i = i2 >= 24 ? 786432 : 0;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.mContext, this.mHost.getClass()), i);
                this.mActivityHandlesUiMode = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager$NameNotFoundException e) {
                Log.d(AppCompatDelegate.TAG, "Exception while getting ActivityInfo", e);
                this.mActivityHandlesUiMode = false;
            }
        }
        this.mActivityHandlesUiModeChecked = true;
        return this.mActivityHandlesUiMode;
    }

    private boolean onKeyDownPanel(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        AppCompatDelegateImpl$PanelFeatureState panelState = getPanelState(i, true);
        if (panelState.isOpen) {
            return false;
        }
        return preparePanel(panelState, keyEvent);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    private boolean onKeyUpPanel(int i, KeyEvent keyEvent) {
        boolean zPreparePanel;
        DecorContentParent decorContentParent;
        if (this.mActionMode != null) {
            return false;
        }
        boolean zHideOverflowMenu = true;
        AppCompatDelegateImpl$PanelFeatureState panelState = getPanelState(i, true);
        if (i != 0 || (decorContentParent = this.mDecorContentParent) == null || !decorContentParent.canShowOverflowMenu() || ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) {
            boolean z2 = panelState.isOpen;
            if (z2 || panelState.isHandled) {
                closePanel(panelState, true);
                zHideOverflowMenu = z2;
            } else if (panelState.isPrepared) {
                if (panelState.refreshMenuContent) {
                    panelState.isPrepared = false;
                    zPreparePanel = preparePanel(panelState, keyEvent);
                } else {
                    zPreparePanel = true;
                }
                if (zPreparePanel) {
                    openPanel(panelState, keyEvent);
                } else {
                    zHideOverflowMenu = false;
                }
            } else {
                zHideOverflowMenu = false;
            }
        } else if (this.mDecorContentParent.isOverflowMenuShowing()) {
            zHideOverflowMenu = this.mDecorContentParent.hideOverflowMenu();
        } else if (this.mIsDestroyed || !preparePanel(panelState, keyEvent)) {
            zHideOverflowMenu = false;
        } else {
            zHideOverflowMenu = this.mDecorContentParent.showOverflowMenu();
        }
        if (zHideOverflowMenu) {
            AudioManager audioManager = (AudioManager) this.mContext.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w(AppCompatDelegate.TAG, "Couldn't get audio manager");
            }
        }
        return zHideOverflowMenu;
    }

    private void openPanel(AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState, KeyEvent keyEvent) {
        int i;
        ViewGroup$LayoutParams layoutParams;
        if (appCompatDelegateImpl$PanelFeatureState.isOpen || this.mIsDestroyed) {
            return;
        }
        if (appCompatDelegateImpl$PanelFeatureState.featureId == 0) {
            if ((this.mContext.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window$Callback windowCallback = getWindowCallback();
        if (windowCallback != null && !windowCallback.onMenuOpened(appCompatDelegateImpl$PanelFeatureState.featureId, appCompatDelegateImpl$PanelFeatureState.menu)) {
            closePanel(appCompatDelegateImpl$PanelFeatureState, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null && preparePanel(appCompatDelegateImpl$PanelFeatureState, keyEvent)) {
            ViewGroup viewGroup = appCompatDelegateImpl$PanelFeatureState.decorView;
            if (viewGroup != null && !appCompatDelegateImpl$PanelFeatureState.refreshDecorView) {
                View view = appCompatDelegateImpl$PanelFeatureState.createdPanelView;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i = -1;
                }
                appCompatDelegateImpl$PanelFeatureState.isHandled = false;
                WindowManager$LayoutParams windowManager$LayoutParams = new WindowManager$LayoutParams(i, -2, appCompatDelegateImpl$PanelFeatureState.f23x, appCompatDelegateImpl$PanelFeatureState.f24y, PointerIconCompat.TYPE_HAND, 8519680, -3);
                windowManager$LayoutParams.gravity = appCompatDelegateImpl$PanelFeatureState.gravity;
                windowManager$LayoutParams.windowAnimations = appCompatDelegateImpl$PanelFeatureState.windowAnimations;
                windowManager.addView(appCompatDelegateImpl$PanelFeatureState.decorView, windowManager$LayoutParams);
                appCompatDelegateImpl$PanelFeatureState.isOpen = true;
            }
            if (viewGroup == null) {
                if (!initializePanelDecor(appCompatDelegateImpl$PanelFeatureState) || appCompatDelegateImpl$PanelFeatureState.decorView == null) {
                    return;
                }
            } else if (appCompatDelegateImpl$PanelFeatureState.refreshDecorView && viewGroup.getChildCount() > 0) {
                appCompatDelegateImpl$PanelFeatureState.decorView.removeAllViews();
            }
            if (!initializePanelContent(appCompatDelegateImpl$PanelFeatureState) || !appCompatDelegateImpl$PanelFeatureState.hasPanelItems()) {
                appCompatDelegateImpl$PanelFeatureState.refreshDecorView = true;
                return;
            }
            ViewGroup$LayoutParams layoutParams2 = appCompatDelegateImpl$PanelFeatureState.shownPanelView.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new ViewGroup$LayoutParams(-2, -2);
            }
            appCompatDelegateImpl$PanelFeatureState.decorView.setBackgroundResource(appCompatDelegateImpl$PanelFeatureState.background);
            ViewParent parent = appCompatDelegateImpl$PanelFeatureState.shownPanelView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(appCompatDelegateImpl$PanelFeatureState.shownPanelView);
            }
            appCompatDelegateImpl$PanelFeatureState.decorView.addView(appCompatDelegateImpl$PanelFeatureState.shownPanelView, layoutParams2);
            if (!appCompatDelegateImpl$PanelFeatureState.shownPanelView.hasFocus()) {
                appCompatDelegateImpl$PanelFeatureState.shownPanelView.requestFocus();
            }
            i = -2;
            appCompatDelegateImpl$PanelFeatureState.isHandled = false;
            WindowManager$LayoutParams windowManager$LayoutParams2 = new WindowManager$LayoutParams(i, -2, appCompatDelegateImpl$PanelFeatureState.f23x, appCompatDelegateImpl$PanelFeatureState.f24y, PointerIconCompat.TYPE_HAND, 8519680, -3);
            windowManager$LayoutParams2.gravity = appCompatDelegateImpl$PanelFeatureState.gravity;
            windowManager$LayoutParams2.windowAnimations = appCompatDelegateImpl$PanelFeatureState.windowAnimations;
            windowManager.addView(appCompatDelegateImpl$PanelFeatureState.decorView, windowManager$LayoutParams2);
            appCompatDelegateImpl$PanelFeatureState.isOpen = true;
        }
    }

    private boolean performPanelShortcut(AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState, int i, KeyEvent keyEvent, int i2) {
        MenuBuilder menuBuilder;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((appCompatDelegateImpl$PanelFeatureState.isPrepared || preparePanel(appCompatDelegateImpl$PanelFeatureState, keyEvent)) && (menuBuilder = appCompatDelegateImpl$PanelFeatureState.menu) != null) {
            zPerformShortcut = menuBuilder.performShortcut(i, keyEvent, i2);
        }
        if (zPerformShortcut && (i2 & 1) == 0 && this.mDecorContentParent == null) {
            closePanel(appCompatDelegateImpl$PanelFeatureState, true);
        }
        return zPerformShortcut;
    }

    private boolean preparePanel(AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState, KeyEvent keyEvent) {
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        DecorContentParent decorContentParent3;
        if (this.mIsDestroyed) {
            return false;
        }
        if (appCompatDelegateImpl$PanelFeatureState.isPrepared) {
            return true;
        }
        AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState2 = this.mPreparedPanel;
        if (appCompatDelegateImpl$PanelFeatureState2 != null && appCompatDelegateImpl$PanelFeatureState2 != appCompatDelegateImpl$PanelFeatureState) {
            closePanel(appCompatDelegateImpl$PanelFeatureState2, false);
        }
        Window$Callback windowCallback = getWindowCallback();
        if (windowCallback != null) {
            appCompatDelegateImpl$PanelFeatureState.createdPanelView = windowCallback.onCreatePanelView(appCompatDelegateImpl$PanelFeatureState.featureId);
        }
        int i = appCompatDelegateImpl$PanelFeatureState.featureId;
        boolean z2 = i == 0 || i == 108;
        if (z2 && (decorContentParent3 = this.mDecorContentParent) != null) {
            decorContentParent3.setMenuPrepared();
        }
        if (appCompatDelegateImpl$PanelFeatureState.createdPanelView == null && (!z2 || !(peekSupportActionBar() instanceof ToolbarActionBar))) {
            MenuBuilder menuBuilder = appCompatDelegateImpl$PanelFeatureState.menu;
            if (menuBuilder == null || appCompatDelegateImpl$PanelFeatureState.refreshMenuContent) {
                if (menuBuilder == null && (!initializePanelMenu(appCompatDelegateImpl$PanelFeatureState) || appCompatDelegateImpl$PanelFeatureState.menu == null)) {
                    return false;
                }
                if (z2 && this.mDecorContentParent != null) {
                    if (this.mActionMenuPresenterCallback == null) {
                        this.mActionMenuPresenterCallback = new AppCompatDelegateImpl$ActionMenuPresenterCallback(this);
                    }
                    this.mDecorContentParent.setMenu(appCompatDelegateImpl$PanelFeatureState.menu, this.mActionMenuPresenterCallback);
                }
                appCompatDelegateImpl$PanelFeatureState.menu.stopDispatchingItemsChanged();
                if (!windowCallback.onCreatePanelMenu(appCompatDelegateImpl$PanelFeatureState.featureId, appCompatDelegateImpl$PanelFeatureState.menu)) {
                    appCompatDelegateImpl$PanelFeatureState.setMenu(null);
                    if (z2 && (decorContentParent = this.mDecorContentParent) != null) {
                        decorContentParent.setMenu(null, this.mActionMenuPresenterCallback);
                    }
                    return false;
                }
                appCompatDelegateImpl$PanelFeatureState.refreshMenuContent = false;
            }
            appCompatDelegateImpl$PanelFeatureState.menu.stopDispatchingItemsChanged();
            Bundle bundle = appCompatDelegateImpl$PanelFeatureState.frozenActionViewState;
            if (bundle != null) {
                appCompatDelegateImpl$PanelFeatureState.menu.restoreActionViewStates(bundle);
                appCompatDelegateImpl$PanelFeatureState.frozenActionViewState = null;
            }
            if (!windowCallback.onPreparePanel(0, appCompatDelegateImpl$PanelFeatureState.createdPanelView, appCompatDelegateImpl$PanelFeatureState.menu)) {
                if (z2 && (decorContentParent2 = this.mDecorContentParent) != null) {
                    decorContentParent2.setMenu(null, this.mActionMenuPresenterCallback);
                }
                appCompatDelegateImpl$PanelFeatureState.menu.startDispatchingItemsChanged();
                return false;
            }
            boolean z3 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            appCompatDelegateImpl$PanelFeatureState.qwertyMode = z3;
            appCompatDelegateImpl$PanelFeatureState.menu.setQwertyMode(z3);
            appCompatDelegateImpl$PanelFeatureState.menu.startDispatchingItemsChanged();
        }
        appCompatDelegateImpl$PanelFeatureState.isPrepared = true;
        appCompatDelegateImpl$PanelFeatureState.isHandled = false;
        this.mPreparedPanel = appCompatDelegateImpl$PanelFeatureState;
        return true;
    }

    private void reopenMenu(boolean z2) {
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent == null || !decorContentParent.canShowOverflowMenu() || (ViewConfiguration.get(this.mContext).hasPermanentMenuKey() && !this.mDecorContentParent.isOverflowMenuShowPending())) {
            AppCompatDelegateImpl$PanelFeatureState panelState = getPanelState(0, true);
            panelState.refreshDecorView = true;
            closePanel(panelState, false);
            openPanel(panelState, null);
            return;
        }
        Window$Callback windowCallback = getWindowCallback();
        if (this.mDecorContentParent.isOverflowMenuShowing() && z2) {
            this.mDecorContentParent.hideOverflowMenu();
            if (this.mIsDestroyed) {
                return;
            }
            windowCallback.onPanelClosed(108, getPanelState(0, true).menu);
            return;
        }
        if (windowCallback == null || this.mIsDestroyed) {
            return;
        }
        if (this.mInvalidatePanelMenuPosted && (this.mInvalidatePanelMenuFeatures & 1) != 0) {
            this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
            this.mInvalidatePanelMenuRunnable.run();
        }
        AppCompatDelegateImpl$PanelFeatureState panelState2 = getPanelState(0, true);
        MenuBuilder menuBuilder = panelState2.menu;
        if (menuBuilder == null || panelState2.refreshMenuContent || !windowCallback.onPreparePanel(0, panelState2.createdPanelView, menuBuilder)) {
            return;
        }
        windowCallback.onMenuOpened(108, panelState2.menu);
        this.mDecorContentParent.showOverflowMenu();
    }

    private int sanitizeWindowFeatureId(int i) {
        if (i == 8) {
            Log.i(AppCompatDelegate.TAG, "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i != 9) {
            return i;
        }
        Log.i(AppCompatDelegate.TAG, "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private boolean shouldInheritContext(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.mWindow.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.isAttachedToWindow((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private void throwFeatureRequestIfSubDecorInstalled() {
        if (this.mSubDecorInstalled) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    @Nullable
    private AppCompatActivity tryUnwrapContext() {
        for (Context baseContext = this.mContext; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof AppCompatActivity) {
                return (AppCompatActivity) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0047  */
    private boolean updateForNightMode(int i, boolean z2) {
        boolean z3;
        Configuration configurationCreateOverrideConfigurationForDayNight = createOverrideConfigurationForDayNight(this.mContext, i, null);
        boolean zIsActivityManifestHandlingUiMode = isActivityManifestHandlingUiMode();
        int i2 = this.mContext.getResources().getConfiguration().uiMode & 48;
        int i3 = configurationCreateOverrideConfigurationForDayNight.uiMode & 48;
        boolean z4 = true;
        if (i2 != i3 && z2 && !zIsActivityManifestHandlingUiMode && this.mBaseContextAttached && (sCanReturnDifferentContext || this.mCreated)) {
            Object obj = this.mHost;
            if (!(obj instanceof Activity) || ((Activity) obj).isChild()) {
                z3 = false;
            } else {
                ActivityCompat.recreate((Activity) this.mHost);
                z3 = true;
            }
        } else {
            z3 = false;
        }
        if (z3 || i2 == i3) {
            z4 = z3;
        } else {
            updateResourcesConfigurationForNightMode(i3, zIsActivityManifestHandlingUiMode, null);
        }
        if (z4) {
            Object obj2 = this.mHost;
            if (obj2 instanceof AppCompatActivity) {
                ((AppCompatActivity) obj2).onNightModeChanged(i);
            }
        }
        return z4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateResourcesConfigurationForNightMode(int i, boolean z2, @Nullable Configuration configuration) {
        Resources resources = this.mContext.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        int i2 = Build$VERSION.SDK_INT;
        if (i2 < 26) {
            ResourcesFlusher.flush(resources);
        }
        int i3 = this.mThemeResId;
        if (i3 != 0) {
            this.mContext.setTheme(i3);
            if (i2 >= 23) {
                this.mContext.getTheme().applyStyle(this.mThemeResId, true);
            }
        }
        if (z2) {
            Object obj = this.mHost;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof LifecycleOwner) {
                    if (((LifecycleOwner) activity).getLifecycle().getCurrentState().isAtLeast(Lifecycle$State.STARTED)) {
                        activity.onConfigurationChanged(configuration2);
                    }
                } else if (this.mStarted) {
                    activity.onConfigurationChanged(configuration2);
                }
            }
        }
    }

    private void updateStatusGuardColor(View view) {
        view.setBackgroundColor((ViewCompat.getWindowSystemUiVisibility(view) & 8192) != 0 ? ContextCompat.getColor(this.mContext, R$color.abc_decor_view_status_guard_light) : ContextCompat.getColor(this.mContext, R$color.abc_decor_view_status_guard));
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void addContentView(View view, ViewGroup$LayoutParams viewGroup$LayoutParams) {
        ensureSubDecor();
        ((ViewGroup) this.mSubDecor.findViewById(R$id.content)).addView(view, viewGroup$LayoutParams);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean applyDayNight() {
        return applyDayNight(true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @NonNull
    @CallSuper
    public Context attachBaseContext2(@NonNull Context context) {
        this.mBaseContextAttached = true;
        int iMapNightMode = mapNightMode(context, calculateNightMode());
        if (sCanApplyOverrideConfiguration && (context instanceof android.view.ContextThemeWrapper)) {
            try {
                AppCompatDelegateImpl$ContextThemeWrapperCompatApi17Impl.applyOverrideConfiguration((android.view.ContextThemeWrapper) context, createOverrideConfigurationForDayNight(context, iMapNightMode, null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(createOverrideConfigurationForDayNight(context, iMapNightMode, null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!sCanReturnDifferentContext) {
            return super.attachBaseContext2(context);
        }
        try {
            Configuration configuration = context.getPackageManager().getResourcesForApplication(context.getApplicationInfo()).getConfiguration();
            Configuration configuration2 = context.getResources().getConfiguration();
            Configuration configurationCreateOverrideConfigurationForDayNight = createOverrideConfigurationForDayNight(context, iMapNightMode, configuration.equals(configuration2) ? null : generateConfigDelta(configuration, configuration2));
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, R$style.Theme_AppCompat_Empty);
            contextThemeWrapper.applyOverrideConfiguration(configurationCreateOverrideConfigurationForDayNight);
            boolean z2 = false;
            try {
                z2 = context.getTheme() != null;
            } catch (NullPointerException unused3) {
            }
            if (z2) {
                ResourcesCompat$ThemeCompat.rebase(contextThemeWrapper.getTheme());
            }
            return super.attachBaseContext2(contextThemeWrapper);
        } catch (PackageManager$NameNotFoundException e) {
            throw new RuntimeException("Application failed to obtain resources from itself", e);
        }
    }

    public void callOnPanelClosed(int i, AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState, Menu menu) {
        if (menu == null) {
            if (appCompatDelegateImpl$PanelFeatureState == null && i >= 0) {
                AppCompatDelegateImpl$PanelFeatureState[] appCompatDelegateImpl$PanelFeatureStateArr = this.mPanels;
                if (i < appCompatDelegateImpl$PanelFeatureStateArr.length) {
                    appCompatDelegateImpl$PanelFeatureState = appCompatDelegateImpl$PanelFeatureStateArr[i];
                }
            }
            if (appCompatDelegateImpl$PanelFeatureState != null) {
                menu = appCompatDelegateImpl$PanelFeatureState.menu;
            }
        }
        if ((appCompatDelegateImpl$PanelFeatureState == null || appCompatDelegateImpl$PanelFeatureState.isOpen) && !this.mIsDestroyed) {
            this.mAppCompatWindowCallback.getWrapped().onPanelClosed(i, menu);
        }
    }

    public void checkCloseActionMenu(@NonNull MenuBuilder menuBuilder) {
        if (this.mClosingActionMenu) {
            return;
        }
        this.mClosingActionMenu = true;
        this.mDecorContentParent.dismissPopups();
        Window$Callback windowCallback = getWindowCallback();
        if (windowCallback != null && !this.mIsDestroyed) {
            windowCallback.onPanelClosed(108, menuBuilder);
        }
        this.mClosingActionMenu = false;
    }

    public void closePanel(int i) {
        closePanel(getPanelState(i, true), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.AppCompatDelegate
    public View createView(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        boolean z2;
        boolean zShouldInheritContext = false;
        if (this.mAppCompatViewInflater == null) {
            String string = this.mContext.obtainStyledAttributes(R$styleable.AppCompatTheme).getString(R$styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.mAppCompatViewInflater = new AppCompatViewInflater();
            } else {
                try {
                    this.mAppCompatViewInflater = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i(AppCompatDelegate.TAG, "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.mAppCompatViewInflater = new AppCompatViewInflater();
                }
            }
        }
        boolean z3 = IS_PRE_LOLLIPOP;
        if (z3) {
            if (!(attributeSet instanceof XmlPullParser)) {
                zShouldInheritContext = shouldInheritContext((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                zShouldInheritContext = true;
            }
            z2 = zShouldInheritContext;
        } else {
            z2 = false;
        }
        return this.mAppCompatViewInflater.createView(view, str, context, attributeSet, z2, z3, true, VectorEnabledTintResources.shouldBeUsed());
    }

    public void dismissPopups() {
        MenuBuilder menuBuilder;
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null) {
            decorContentParent.dismissPopups();
        }
        if (this.mActionModePopup != null) {
            this.mWindow.getDecorView().removeCallbacks(this.mShowActionModePopup);
            if (this.mActionModePopup.isShowing()) {
                try {
                    this.mActionModePopup.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.mActionModePopup = null;
        }
        endOnGoingFadeAnimation();
        AppCompatDelegateImpl$PanelFeatureState panelState = getPanelState(0, false);
        if (panelState == null || (menuBuilder = panelState.menu) == null) {
            return;
        }
        menuBuilder.close();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.mHost;
        if (((obj instanceof KeyEventDispatcher$Component) || (obj instanceof AppCompatDialog)) && (decorView = this.mWindow.getDecorView()) != null && KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.mAppCompatWindowCallback.getWrapped().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent);
    }

    public void doInvalidatePanelMenu(int i) {
        AppCompatDelegateImpl$PanelFeatureState panelState;
        AppCompatDelegateImpl$PanelFeatureState panelState2 = getPanelState(i, true);
        if (panelState2.menu != null) {
            Bundle bundle = new Bundle();
            panelState2.menu.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                panelState2.frozenActionViewState = bundle;
            }
            panelState2.menu.stopDispatchingItemsChanged();
            panelState2.menu.clear();
        }
        panelState2.refreshMenuContent = true;
        panelState2.refreshDecorView = true;
        if ((i != 108 && i != 0) || this.mDecorContentParent == null || (panelState = getPanelState(0, false)) == null) {
            return;
        }
        panelState.isPrepared = false;
        preparePanel(panelState, null);
    }

    public void endOnGoingFadeAnimation() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mFadeAnim;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
    }

    public AppCompatDelegateImpl$PanelFeatureState findMenuPanel(Menu menu) {
        AppCompatDelegateImpl$PanelFeatureState[] appCompatDelegateImpl$PanelFeatureStateArr = this.mPanels;
        int length = appCompatDelegateImpl$PanelFeatureStateArr != null ? appCompatDelegateImpl$PanelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState = appCompatDelegateImpl$PanelFeatureStateArr[i];
            if (appCompatDelegateImpl$PanelFeatureState != null && appCompatDelegateImpl$PanelFeatureState.menu == menu) {
                return appCompatDelegateImpl$PanelFeatureState;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @Nullable
    public <T extends View> T findViewById(@IdRes int i) {
        ensureSubDecor();
        return (T) this.mWindow.findViewById(i);
    }

    public final Context getActionBarThemedContext() {
        ActionBar supportActionBar = getSupportActionBar();
        Context themedContext = supportActionBar != null ? supportActionBar.getThemedContext() : null;
        return themedContext == null ? this.mContext : themedContext;
    }

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    @VisibleForTesting
    public final AppCompatDelegateImpl$AutoNightModeManager getAutoTimeNightModeManager() {
        return getAutoTimeNightModeManager(this.mContext);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final ActionBarDrawerToggle$Delegate getDrawerToggleDelegate() {
        return new AppCompatDelegateImpl$ActionBarDrawableToggleImpl(this);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public int getLocalNightMode() {
        return this.mLocalNightMode;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public MenuInflater getMenuInflater() {
        if (this.mMenuInflater == null) {
            initWindowDecorActionBar();
            ActionBar actionBar = this.mActionBar;
            this.mMenuInflater = new SupportMenuInflater(actionBar != null ? actionBar.getThemedContext() : this.mContext);
        }
        return this.mMenuInflater;
    }

    public AppCompatDelegateImpl$PanelFeatureState getPanelState(int i, boolean z2) {
        AppCompatDelegateImpl$PanelFeatureState[] appCompatDelegateImpl$PanelFeatureStateArr = this.mPanels;
        if (appCompatDelegateImpl$PanelFeatureStateArr == null || appCompatDelegateImpl$PanelFeatureStateArr.length <= i) {
            AppCompatDelegateImpl$PanelFeatureState[] appCompatDelegateImpl$PanelFeatureStateArr2 = new AppCompatDelegateImpl$PanelFeatureState[i + 1];
            if (appCompatDelegateImpl$PanelFeatureStateArr != null) {
                System.arraycopy(appCompatDelegateImpl$PanelFeatureStateArr, 0, appCompatDelegateImpl$PanelFeatureStateArr2, 0, appCompatDelegateImpl$PanelFeatureStateArr.length);
            }
            this.mPanels = appCompatDelegateImpl$PanelFeatureStateArr2;
            appCompatDelegateImpl$PanelFeatureStateArr = appCompatDelegateImpl$PanelFeatureStateArr2;
        }
        AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState = appCompatDelegateImpl$PanelFeatureStateArr[i];
        if (appCompatDelegateImpl$PanelFeatureState != null) {
            return appCompatDelegateImpl$PanelFeatureState;
        }
        AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState2 = new AppCompatDelegateImpl$PanelFeatureState(i);
        appCompatDelegateImpl$PanelFeatureStateArr[i] = appCompatDelegateImpl$PanelFeatureState2;
        return appCompatDelegateImpl$PanelFeatureState2;
    }

    public ViewGroup getSubDecor() {
        return this.mSubDecor;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionBar getSupportActionBar() {
        initWindowDecorActionBar();
        return this.mActionBar;
    }

    public final CharSequence getTitle() {
        Object obj = this.mHost;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.mTitle;
    }

    public final Window$Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean hasWindowFeature(int i) {
        boolean z2;
        int iSanitizeWindowFeatureId = sanitizeWindowFeatureId(i);
        if (iSanitizeWindowFeatureId == 1) {
            z2 = this.mWindowNoTitle;
        } else if (iSanitizeWindowFeatureId == 2) {
            z2 = this.mFeatureProgress;
        } else if (iSanitizeWindowFeatureId == 5) {
            z2 = this.mFeatureIndeterminateProgress;
        } else if (iSanitizeWindowFeatureId == 10) {
            z2 = this.mOverlayActionMode;
        } else if (iSanitizeWindowFeatureId != 108) {
            z2 = iSanitizeWindowFeatureId != 109 ? false : this.mOverlayActionBar;
        } else {
            z2 = this.mHasActionBar;
        }
        return z2 || this.mWindow.hasFeature(i);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void installViewFactory() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.mContext);
        if (layoutInflaterFrom.getFactory() == null) {
            LayoutInflaterCompat.setFactory2(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof AppCompatDelegateImpl) {
                return;
            }
            Log.i(AppCompatDelegate.TAG, "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void invalidateOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.invalidateOptionsMenu()) {
            invalidatePanelMenu(0);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean isHandleNativeActionModesEnabled() {
        return this.mHandleNativeActionModes;
    }

    public int mapNightMode(@NonNull Context context, int i) {
        if (i == -100) {
            return -1;
        }
        if (i != -1) {
            if (i == 0) {
                if (Build$VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() != 0) {
                    return getAutoTimeNightModeManager(context).getApplyableNightMode();
                }
                return -1;
            }
            if (i != 1 && i != 2) {
                if (i == 3) {
                    return getAutoBatteryNightModeManager(context).getApplyableNightMode();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i;
    }

    public boolean onBackPressed() {
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        return supportActionBar != null && supportActionBar.collapseActionView();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onConfigurationChanged(Configuration configuration) {
        ActionBar supportActionBar;
        if (this.mHasActionBar && this.mSubDecorInstalled && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.onConfigurationChanged(configuration);
        }
        AppCompatDrawableManager.get().onConfigurationChanged(this.mContext);
        applyDayNight(false);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onCreate(Bundle bundle) {
        this.mBaseContextAttached = true;
        applyDayNight(false);
        ensureWindow();
        Object obj = this.mHost;
        if (obj instanceof Activity) {
            String parentActivityName = null;
            try {
                parentActivityName = NavUtils.getParentActivityName((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (parentActivityName != null) {
                ActionBar actionBarPeekSupportActionBar = peekSupportActionBar();
                if (actionBarPeekSupportActionBar == null) {
                    this.mEnableDefaultActionBarUp = true;
                } else {
                    actionBarPeekSupportActionBar.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
            AppCompatDelegate.addActiveDelegate(this);
        }
        this.mCreated = true;
    }

    @Override // android.view.LayoutInflater$Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return createView(view, str, context, attributeSet);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0048  */
    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onDestroy() {
        if (this.mHost instanceof Activity) {
            AppCompatDelegate.removeActivityDelegate(this);
        }
        if (this.mInvalidatePanelMenuPosted) {
            this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
        }
        this.mStarted = false;
        this.mIsDestroyed = true;
        if (this.mLocalNightMode != -100) {
            Object obj = this.mHost;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                sLocalNightModes.put(this.mHost.getClass().getName(), Integer.valueOf(this.mLocalNightMode));
            } else {
                sLocalNightModes.remove(this.mHost.getClass().getName());
            }
        } else {
            sLocalNightModes.remove(this.mHost.getClass().getName());
        }
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            actionBar.onDestroy();
        }
        cleanupAutoManagers();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.mLongPressBackDown = (keyEvent.getFlags() & 128) != 0;
        } else if (i == 82) {
            onKeyDownPanel(0, keyEvent);
            return true;
        }
        return false;
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null && supportActionBar.onKeyShortcut(i, keyEvent)) {
            return true;
        }
        AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState = this.mPreparedPanel;
        if (appCompatDelegateImpl$PanelFeatureState != null && performPanelShortcut(appCompatDelegateImpl$PanelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState2 = this.mPreparedPanel;
            if (appCompatDelegateImpl$PanelFeatureState2 != null) {
                appCompatDelegateImpl$PanelFeatureState2.isHandled = true;
            }
            return true;
        }
        if (this.mPreparedPanel == null) {
            AppCompatDelegateImpl$PanelFeatureState panelState = getPanelState(0, true);
            preparePanel(panelState, keyEvent);
            boolean zPerformPanelShortcut = performPanelShortcut(panelState, keyEvent.getKeyCode(), keyEvent, 1);
            panelState.isPrepared = false;
            if (zPerformPanelShortcut) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z2 = this.mLongPressBackDown;
            this.mLongPressBackDown = false;
            AppCompatDelegateImpl$PanelFeatureState panelState = getPanelState(0, false);
            if (panelState != null && panelState.isOpen) {
                if (!z2) {
                    closePanel(panelState, true);
                }
                return true;
            }
            if (onBackPressed()) {
                return true;
            }
        } else if (i == 82) {
            onKeyUpPanel(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder$Callback
    public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureStateFindMenuPanel;
        Window$Callback windowCallback = getWindowCallback();
        if (windowCallback == null || this.mIsDestroyed || (appCompatDelegateImpl$PanelFeatureStateFindMenuPanel = findMenuPanel(menuBuilder.getRootMenu())) == null) {
            return false;
        }
        return windowCallback.onMenuItemSelected(appCompatDelegateImpl$PanelFeatureStateFindMenuPanel.featureId, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder$Callback
    public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
        reopenMenu(true);
    }

    public void onMenuOpened(int i) {
        ActionBar supportActionBar;
        if (i != 108 || (supportActionBar = getSupportActionBar()) == null) {
            return;
        }
        supportActionBar.dispatchMenuVisibilityChanged(true);
    }

    public void onPanelClosed(int i) {
        if (i == 108) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.dispatchMenuVisibilityChanged(false);
                return;
            }
            return;
        }
        if (i == 0) {
            AppCompatDelegateImpl$PanelFeatureState panelState = getPanelState(i, true);
            if (panelState.isOpen) {
                closePanel(panelState, false);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostCreate(Bundle bundle) {
        ensureSubDecor();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostResume() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(true);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStart() {
        this.mStarted = true;
        applyDayNight();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStop() {
        this.mStarted = false;
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
        }
    }

    public void onSubDecorInstalled(ViewGroup viewGroup) {
    }

    public final ActionBar peekSupportActionBar() {
        return this.mActionBar;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean requestWindowFeature(int i) {
        int iSanitizeWindowFeatureId = sanitizeWindowFeatureId(i);
        if (this.mWindowNoTitle && iSanitizeWindowFeatureId == 108) {
            return false;
        }
        if (this.mHasActionBar && iSanitizeWindowFeatureId == 1) {
            this.mHasActionBar = false;
        }
        if (iSanitizeWindowFeatureId == 1) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mWindowNoTitle = true;
            return true;
        }
        if (iSanitizeWindowFeatureId == 2) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureProgress = true;
            return true;
        }
        if (iSanitizeWindowFeatureId == 5) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureIndeterminateProgress = true;
            return true;
        }
        if (iSanitizeWindowFeatureId == 10) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mOverlayActionMode = true;
            return true;
        }
        if (iSanitizeWindowFeatureId == 108) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mHasActionBar = true;
            return true;
        }
        if (iSanitizeWindowFeatureId != 109) {
            return this.mWindow.requestFeature(iSanitizeWindowFeatureId);
        }
        throwFeatureRequestIfSubDecorInstalled();
        this.mOverlayActionBar = true;
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View view) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(R$id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setHandleNativeActionModesEnabled(boolean z2) {
        this.mHandleNativeActionModes = z2;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @RequiresApi(17)
    public void setLocalNightMode(int i) {
        if (this.mLocalNightMode != i) {
            this.mLocalNightMode = i;
            if (this.mBaseContextAttached) {
                applyDayNight();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setSupportActionBar(Toolbar toolbar) {
        if (this.mHost instanceof Activity) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar instanceof WindowDecorActionBar) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.mMenuInflater = null;
            if (supportActionBar != null) {
                supportActionBar.onDestroy();
            }
            if (toolbar != null) {
                ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, getTitle(), this.mAppCompatWindowCallback);
                this.mActionBar = toolbarActionBar;
                this.mWindow.setCallback(toolbarActionBar.getWrappedWindowCallback());
            } else {
                this.mActionBar = null;
                this.mWindow.setCallback(this.mAppCompatWindowCallback);
            }
            invalidateOptionsMenu();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setTheme(@StyleRes int i) {
        this.mThemeResId = i;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
            return;
        }
        if (peekSupportActionBar() != null) {
            peekSupportActionBar().setWindowTitle(charSequence);
            return;
        }
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final boolean shouldAnimateActionModeView() {
        ViewGroup viewGroup;
        return this.mSubDecorInstalled && (viewGroup = this.mSubDecor) != null && ViewCompat.isLaidOut(viewGroup);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionMode startSupportActionMode(@NonNull ActionMode$Callback actionMode$Callback) {
        AppCompatCallback appCompatCallback;
        if (actionMode$Callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        AppCompatDelegateImpl$ActionModeCallbackWrapperV9 appCompatDelegateImpl$ActionModeCallbackWrapperV9 = new AppCompatDelegateImpl$ActionModeCallbackWrapperV9(this, actionMode$Callback);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            ActionMode actionModeStartActionMode = supportActionBar.startActionMode(appCompatDelegateImpl$ActionModeCallbackWrapperV9);
            this.mActionMode = actionModeStartActionMode;
            if (actionModeStartActionMode != null && (appCompatCallback = this.mAppCompatCallback) != null) {
                appCompatCallback.onSupportActionModeStarted(actionModeStartActionMode);
            }
        }
        if (this.mActionMode == null) {
            this.mActionMode = startSupportActionModeFromWindow(appCompatDelegateImpl$ActionModeCallbackWrapperV9);
        }
        return this.mActionMode;
    }

    public ActionMode startSupportActionModeFromWindow(@NonNull ActionMode$Callback actionMode$Callback) {
        ActionMode actionModeOnWindowStartingSupportActionMode;
        Context contextThemeWrapper;
        AppCompatCallback appCompatCallback;
        endOnGoingFadeAnimation();
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        if (!(actionMode$Callback instanceof AppCompatDelegateImpl$ActionModeCallbackWrapperV9)) {
            actionMode$Callback = new AppCompatDelegateImpl$ActionModeCallbackWrapperV9(this, actionMode$Callback);
        }
        AppCompatCallback appCompatCallback2 = this.mAppCompatCallback;
        if (appCompatCallback2 == null || this.mIsDestroyed) {
            actionModeOnWindowStartingSupportActionMode = null;
        } else {
            try {
                actionModeOnWindowStartingSupportActionMode = appCompatCallback2.onWindowStartingSupportActionMode(actionMode$Callback);
            } catch (AbstractMethodError unused) {
                actionModeOnWindowStartingSupportActionMode = null;
            }
        }
        if (actionModeOnWindowStartingSupportActionMode != null) {
            this.mActionMode = actionModeOnWindowStartingSupportActionMode;
        } else {
            if (this.mActionModeView == null) {
                if (this.mIsFloating) {
                    TypedValue typedValue = new TypedValue();
                    Resources$Theme theme = this.mContext.getTheme();
                    theme.resolveAttribute(androidx.appcompat.R$attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources$Theme resources$ThemeNewTheme = this.mContext.getResources().newTheme();
                        resources$ThemeNewTheme.setTo(theme);
                        resources$ThemeNewTheme.applyStyle(typedValue.resourceId, true);
                        contextThemeWrapper = new ContextThemeWrapper(this.mContext, 0);
                        contextThemeWrapper.getTheme().setTo(resources$ThemeNewTheme);
                    } else {
                        contextThemeWrapper = this.mContext;
                    }
                    this.mActionModeView = new ActionBarContextView(contextThemeWrapper);
                    PopupWindow popupWindow = new PopupWindow(contextThemeWrapper, (AttributeSet) null, androidx.appcompat.R$attr.actionModePopupWindowStyle);
                    this.mActionModePopup = popupWindow;
                    PopupWindowCompat.setWindowLayoutType(popupWindow, 2);
                    this.mActionModePopup.setContentView(this.mActionModeView);
                    this.mActionModePopup.setWidth(-1);
                    contextThemeWrapper.getTheme().resolveAttribute(androidx.appcompat.R$attr.actionBarSize, typedValue, true);
                    this.mActionModeView.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, contextThemeWrapper.getResources().getDisplayMetrics()));
                    this.mActionModePopup.setHeight(-2);
                    this.mShowActionModePopup = new AppCompatDelegateImpl$6(this);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.mSubDecor.findViewById(androidx.appcompat.R$id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(getActionBarThemedContext()));
                        this.mActionModeView = (ActionBarContextView) viewStubCompat.inflate();
                    }
                }
            }
            if (this.mActionModeView != null) {
                endOnGoingFadeAnimation();
                this.mActionModeView.killMode();
                StandaloneActionMode standaloneActionMode = new StandaloneActionMode(this.mActionModeView.getContext(), this.mActionModeView, actionMode$Callback, this.mActionModePopup == null);
                if (actionMode$Callback.onCreateActionMode(standaloneActionMode, standaloneActionMode.getMenu())) {
                    standaloneActionMode.invalidate();
                    this.mActionModeView.initForMode(standaloneActionMode);
                    this.mActionMode = standaloneActionMode;
                    if (shouldAnimateActionModeView()) {
                        this.mActionModeView.setAlpha(0.0f);
                        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAlpha = ViewCompat.animate(this.mActionModeView).alpha(1.0f);
                        this.mFadeAnim = viewPropertyAnimatorCompatAlpha;
                        viewPropertyAnimatorCompatAlpha.setListener(new AppCompatDelegateImpl$7(this));
                    } else {
                        this.mActionModeView.setAlpha(1.0f);
                        this.mActionModeView.setVisibility(0);
                        this.mActionModeView.sendAccessibilityEvent(32);
                        if (this.mActionModeView.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View) this.mActionModeView.getParent());
                        }
                    }
                    if (this.mActionModePopup != null) {
                        this.mWindow.getDecorView().post(this.mShowActionModePopup);
                    }
                } else {
                    this.mActionMode = null;
                }
            }
        }
        ActionMode actionMode2 = this.mActionMode;
        if (actionMode2 != null && (appCompatCallback = this.mAppCompatCallback) != null) {
            appCompatCallback.onSupportActionModeStarted(actionMode2);
        }
        return this.mActionMode;
    }

    public final int updateStatusGuard(@Nullable WindowInsetsCompat windowInsetsCompat, @Nullable Rect rect) {
        int systemWindowInsetTop;
        boolean z2;
        boolean z3;
        if (windowInsetsCompat != null) {
            systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        } else {
            systemWindowInsetTop = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.mActionModeView;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup$MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) this.mActionModeView.getLayoutParams();
            boolean z4 = true;
            if (this.mActionModeView.isShown()) {
                if (this.mTempRect1 == null) {
                    this.mTempRect1 = new Rect();
                    this.mTempRect2 = new Rect();
                }
                Rect rect2 = this.mTempRect1;
                Rect rect3 = this.mTempRect2;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                }
                ViewUtils.computeFitSystemWindows(this.mSubDecor, rect2, rect3);
                int i = rect2.top;
                int i2 = rect2.left;
                int i3 = rect2.right;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.mSubDecor);
                int systemWindowInsetLeft = rootWindowInsets == null ? 0 : rootWindowInsets.getSystemWindowInsetLeft();
                int systemWindowInsetRight = rootWindowInsets == null ? 0 : rootWindowInsets.getSystemWindowInsetRight();
                if (viewGroup$MarginLayoutParams.topMargin == i && viewGroup$MarginLayoutParams.leftMargin == i2 && viewGroup$MarginLayoutParams.rightMargin == i3) {
                    z3 = false;
                } else {
                    viewGroup$MarginLayoutParams.topMargin = i;
                    viewGroup$MarginLayoutParams.leftMargin = i2;
                    viewGroup$MarginLayoutParams.rightMargin = i3;
                    z3 = true;
                }
                if (i <= 0 || this.mStatusGuard != null) {
                    View view = this.mStatusGuard;
                    if (view != null) {
                        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams2 = (ViewGroup$MarginLayoutParams) view.getLayoutParams();
                        int i4 = viewGroup$MarginLayoutParams2.height;
                        int i5 = viewGroup$MarginLayoutParams.topMargin;
                        if (i4 != i5 || viewGroup$MarginLayoutParams2.leftMargin != systemWindowInsetLeft || viewGroup$MarginLayoutParams2.rightMargin != systemWindowInsetRight) {
                            viewGroup$MarginLayoutParams2.height = i5;
                            viewGroup$MarginLayoutParams2.leftMargin = systemWindowInsetLeft;
                            viewGroup$MarginLayoutParams2.rightMargin = systemWindowInsetRight;
                            this.mStatusGuard.setLayoutParams(viewGroup$MarginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.mContext);
                    this.mStatusGuard = view2;
                    view2.setVisibility(8);
                    FrameLayout$LayoutParams frameLayout$LayoutParams = new FrameLayout$LayoutParams(-1, viewGroup$MarginLayoutParams.topMargin, 51);
                    frameLayout$LayoutParams.leftMargin = systemWindowInsetLeft;
                    frameLayout$LayoutParams.rightMargin = systemWindowInsetRight;
                    this.mSubDecor.addView(this.mStatusGuard, -1, frameLayout$LayoutParams);
                }
                View view3 = this.mStatusGuard;
                z4 = view3 != null;
                if (z4 && view3.getVisibility() != 0) {
                    updateStatusGuardColor(this.mStatusGuard);
                }
                if (!this.mOverlayActionMode && z4) {
                    systemWindowInsetTop = 0;
                }
                z2 = z4;
                z4 = z3;
            } else if (viewGroup$MarginLayoutParams.topMargin != 0) {
                viewGroup$MarginLayoutParams.topMargin = 0;
                z2 = false;
            } else {
                z2 = false;
                z4 = false;
            }
            if (z4) {
                this.mActionModeView.setLayoutParams(viewGroup$MarginLayoutParams);
            }
        }
        View view4 = this.mStatusGuard;
        if (view4 != null) {
            view4.setVisibility(z2 ? 0 : 8);
        }
        return systemWindowInsetTop;
    }

    public AppCompatDelegateImpl(Dialog dialog, AppCompatCallback appCompatCallback) {
        this(dialog.getContext(), dialog.getWindow(), appCompatCallback, dialog);
    }

    private boolean applyDayNight(boolean z2) {
        if (this.mIsDestroyed) {
            return false;
        }
        int iCalculateNightMode = calculateNightMode();
        boolean zUpdateForNightMode = updateForNightMode(mapNightMode(this.mContext, iCalculateNightMode), z2);
        if (iCalculateNightMode == 0) {
            getAutoTimeNightModeManager(this.mContext).setup();
        } else {
            AppCompatDelegateImpl$AutoNightModeManager appCompatDelegateImpl$AutoNightModeManager = this.mAutoTimeNightModeManager;
            if (appCompatDelegateImpl$AutoNightModeManager != null) {
                appCompatDelegateImpl$AutoNightModeManager.cleanup();
            }
        }
        if (iCalculateNightMode == 3) {
            getAutoBatteryNightModeManager(this.mContext).setup();
        } else {
            AppCompatDelegateImpl$AutoNightModeManager appCompatDelegateImpl$AutoNightModeManager2 = this.mAutoBatteryNightModeManager;
            if (appCompatDelegateImpl$AutoNightModeManager2 != null) {
                appCompatDelegateImpl$AutoNightModeManager2.cleanup();
            }
        }
        return zUpdateForNightMode;
    }

    private AppCompatDelegateImpl$AutoNightModeManager getAutoTimeNightModeManager(@NonNull Context context) {
        if (this.mAutoTimeNightModeManager == null) {
            this.mAutoTimeNightModeManager = new AppCompatDelegateImpl$AutoTimeNightModeManager(this, TwilightManager.getInstance(context));
        }
        return this.mAutoTimeNightModeManager;
    }

    public void closePanel(AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState, boolean z2) {
        ViewGroup viewGroup;
        DecorContentParent decorContentParent;
        if (z2 && appCompatDelegateImpl$PanelFeatureState.featureId == 0 && (decorContentParent = this.mDecorContentParent) != null && decorContentParent.isOverflowMenuShowing()) {
            checkCloseActionMenu(appCompatDelegateImpl$PanelFeatureState.menu);
            return;
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null && appCompatDelegateImpl$PanelFeatureState.isOpen && (viewGroup = appCompatDelegateImpl$PanelFeatureState.decorView) != null) {
            windowManager.removeView(viewGroup);
            if (z2) {
                callOnPanelClosed(appCompatDelegateImpl$PanelFeatureState.featureId, appCompatDelegateImpl$PanelFeatureState, null);
            }
        }
        appCompatDelegateImpl$PanelFeatureState.isPrepared = false;
        appCompatDelegateImpl$PanelFeatureState.isHandled = false;
        appCompatDelegateImpl$PanelFeatureState.isOpen = false;
        appCompatDelegateImpl$PanelFeatureState.shownPanelView = null;
        appCompatDelegateImpl$PanelFeatureState.refreshDecorView = true;
        if (this.mPreparedPanel == appCompatDelegateImpl$PanelFeatureState) {
            this.mPreparedPanel = null;
        }
    }

    @Override // android.view.LayoutInflater$Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback) {
        this(context, window, appCompatCallback, context);
    }

    public AppCompatDelegateImpl(Context context, Activity activity, AppCompatCallback appCompatCallback) {
        this(context, null, appCompatCallback, activity);
    }

    private AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback, Object obj) {
        SimpleArrayMap<String, Integer> simpleArrayMap;
        Integer num;
        AppCompatActivity appCompatActivityTryUnwrapContext;
        this.mFadeAnim = null;
        this.mHandleNativeActionModes = true;
        this.mLocalNightMode = -100;
        this.mInvalidatePanelMenuRunnable = new AppCompatDelegateImpl$2(this);
        this.mContext = context;
        this.mAppCompatCallback = appCompatCallback;
        this.mHost = obj;
        if (this.mLocalNightMode == -100 && (obj instanceof Dialog) && (appCompatActivityTryUnwrapContext = tryUnwrapContext()) != null) {
            this.mLocalNightMode = appCompatActivityTryUnwrapContext.getDelegate().getLocalNightMode();
        }
        if (this.mLocalNightMode == -100 && (num = (simpleArrayMap = sLocalNightModes).get(obj.getClass().getName())) != null) {
            this.mLocalNightMode = num.intValue();
            simpleArrayMap.remove(obj.getClass().getName());
        }
        if (window != null) {
            attachToWindow(window);
        }
        AppCompatDrawableManager.preload();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(int i) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(R$id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View view, ViewGroup$LayoutParams viewGroup$LayoutParams) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(R$id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, viewGroup$LayoutParams);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }
}
