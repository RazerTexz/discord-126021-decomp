package com.discord.app;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppActivity2;
import b.a.d.AppFragment2;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.a.l.MediaPickerChooser2;
import b.b.a.f.SimpleFileManager;
import com.discord.R;
import com.discord.app.AppLogger;
import com.discord.media_picker.MediaPicker;
import com.discord.media_picker.RequestType;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.attachments.AttachmentUtils;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.view.text.TextWatcher;
import com.discord.views.ToolbarTitleLayout;
import com.lytefast.flexinput.managers.FileManager;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/* JADX INFO: compiled from: AppFragment.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppFragment extends Fragment implements AppComponent, AppPermissions2, MediaPicker.Provider, AppLogger.a {

    /* JADX INFO: renamed from: appLogger$delegate, reason: from kotlin metadata */
    private final Lazy appLogger;

    /* JADX INFO: renamed from: fileManager$delegate, reason: from kotlin metadata */
    private final Lazy fileManager;
    private boolean isRecreated;
    private final AppLogger2 loggingConfig;
    private boolean onViewBoundOrOnResumeInvoked;
    private final Subject<Void, Void> unsubscribeSignal;

    /* JADX INFO: compiled from: AppFragment.kt */
    public static final class a extends Lambda implements Function0<AppLogger> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppLogger invoke() {
            return new AppLogger(AppFragment.this, null, false, 6);
        }
    }

    /* JADX INFO: compiled from: AppFragment.kt */
    public static final class b extends Lambda implements Function0<SimpleFileManager> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public SimpleFileManager invoke() {
            return new SimpleFileManager(AppFragment.this.requireContext(), null, null, 6);
        }
    }

    /* JADX INFO: compiled from: AppFragment.kt */
    public static final class c implements MediaPicker.a {
        public c() {
        }

        @Override // com.discord.media_picker.MediaPicker.a
        public void a(Exception exc) {
            Intrinsics3.checkNotNullParameter(exc, "e");
            AppToast.h(AppFragment.this.getContext(), FormatUtils.e(AppFragment.this, R.string.upload_open_file_failed, new Object[]{exc.getMessage()}, (4 & 4) != 0 ? FormatUtils.a.j : null), 0, null, 12);
        }

        @Override // com.discord.media_picker.MediaPicker.a
        public void b(Uri uri, RequestType requestType) {
            Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Intrinsics3.checkNotNullParameter(requestType, "request");
            String mimeType$default = AttachmentUtils.getMimeType$default(AppFragment.this.requireContext().getContentResolver(), uri, null, 4, null);
            if (requestType.ordinal() != 3) {
                AppFragment.this.onImageChosen(uri, mimeType$default);
            } else {
                AppFragment.this.onImageCropped(uri, mimeType$default);
            }
        }
    }

    /* JADX INFO: compiled from: AppFragment.kt */
    public static final class d extends Lambda implements Function0<Unit> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            MediaPicker mediaPicker = MediaPicker.a;
            AppFragment appFragment = AppFragment.this;
            CharSequence charSequenceE = FormatUtils.e(appFragment, R.string.choose_an_application, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
            AppFragment2 appFragment2 = new AppFragment2(this);
            Intrinsics3.checkNotNullParameter(appFragment, "provider");
            Intrinsics3.checkNotNullParameter(charSequenceE, "chooserTitle");
            Intrinsics3.checkNotNullParameter("image/*", "mimeType");
            Intrinsics3.checkNotNullParameter(appFragment2, "onError");
            try {
                Uri uriA = mediaPicker.a(appFragment);
                PackageManager packageManager = appFragment.requireContext().getPackageManager();
                Intrinsics3.checkNotNullExpressionValue(packageManager, "provider.requireContext().packageManager");
                Intent intentB = MediaPickerChooser2.b(packageManager, charSequenceE, uriA, "image/*");
                mediaPicker.c(appFragment.requireContext(), new Intent("android.media.action.IMAGE_CAPTURE"), uriA);
                try {
                    appFragment.startActivityForResult(intentB, RequestType.CHOOSER.getCode$media_picker_release());
                } catch (ActivityNotFoundException unused) {
                    throw new IOException("No application available for media picker.");
                }
            } catch (IOException e) {
                appFragment2.invoke(e);
            }
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: AppFragment.kt */
    public static final class e extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ Func0 $onBackAction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Func0 func0) {
            super(0);
            this.$onBackAction = func0;
        }

        @Override // kotlin.jvm.functions.Function0
        public Boolean invoke() {
            Object objCall = this.$onBackAction.call();
            Intrinsics3.checkNotNullExpressionValue(objCall, "onBackAction.call()");
            return Boolean.valueOf(((Boolean) objCall).booleanValue());
        }
    }

    public AppFragment() {
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
        this.fileManager = LazyJVM.lazy(new b());
        this.appLogger = LazyJVM.lazy(new a());
    }

    public static /* synthetic */ Unit bindToolbar$default(AppFragment appFragment, View view, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindToolbar");
        }
        if ((i & 1) != 0) {
            view = null;
        }
        return appFragment.bindToolbar(view);
    }

    public static /* synthetic */ void hideKeyboard$default(AppFragment appFragment, View view, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideKeyboard");
        }
        if ((i & 1) != 0) {
            view = null;
        }
        appFragment.hideKeyboard(view);
    }

    public static /* synthetic */ Toolbar setActionBarDisplayHomeAsUpEnabled$default(AppFragment appFragment, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setActionBarDisplayHomeAsUpEnabled");
        }
        if ((i & 1) != 0) {
            z2 = true;
        }
        return appFragment.setActionBarDisplayHomeAsUpEnabled(z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Toolbar setActionBarOptionsMenu$default(AppFragment appFragment, int i, Action2 action2, Action1 action1, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setActionBarOptionsMenu");
        }
        if ((i2 & 4) != 0) {
            action1 = null;
        }
        return appFragment.setActionBarOptionsMenu(i, action2, action1);
    }

    public static /* synthetic */ void setOnBackPressed$default(AppFragment appFragment, Func0 func0, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOnBackPressed");
        }
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        appFragment.setOnBackPressed(func0, i);
    }

    @CallSuper
    public Unit bindToolbar(View view) {
        AppActivity appActivity = getAppActivity();
        if (appActivity == null) {
            return null;
        }
        if (view == null) {
            view = getView();
        }
        return bindToolbar(appActivity, view);
    }

    public final ToolbarTitleLayout getActionBarTitleLayout() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            return appActivity.e();
        }
        return null;
    }

    public final AppActivity getAppActivity() {
        return (AppActivity) e();
    }

    public final AppLogger getAppLogger() {
        return (AppLogger) this.appLogger.getValue();
    }

    public final FileManager getFileManager() {
        return (FileManager) this.fileManager.getValue();
    }

    @Override // com.discord.media_picker.MediaPicker.Provider
    public File getImageFile() {
        return getFileManager().b();
    }

    @Override // com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public final Intent getMostRecentIntent() {
        Intent intentC;
        AppActivity appActivity = getAppActivity();
        return (appActivity == null || (intentC = appActivity.c()) == null) ? new Intent() : intentC;
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.unsubscribeSignal;
    }

    @Override // com.discord.app.AppPermissions2
    public boolean hasMedia() {
        return requireAppActivity().appPermissions.hasMedia();
    }

    public final void hideKeyboard() {
        hideKeyboard$default(this, null, 1, null);
    }

    public void hideKeyboard(View view) {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.hideKeyboard(view);
        }
    }

    /* JADX INFO: renamed from: isRecreated, reason: from getter */
    public final boolean getIsRecreated() {
        return this.isRecreated;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        RequestType requestType;
        super.onActivityResult(requestCode, resultCode, data);
        MediaPicker mediaPicker = MediaPicker.a;
        Context contextRequireContext = requireContext();
        c cVar = new c();
        Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
        Intrinsics3.checkNotNullParameter(cVar, "result");
        Objects.requireNonNull(RequestType.INSTANCE);
        if (requestCode == 800) {
            requestType = RequestType.CROP;
        } else if (requestCode != 801) {
            switch (requestCode) {
                case 777:
                    requestType = RequestType.CAMERA;
                    break;
                case 778:
                    requestType = RequestType.GALLERY;
                    break;
                case 779:
                    requestType = RequestType.DOCUMENTS;
                    break;
                default:
                    requestType = null;
                    break;
            }
        } else {
            requestType = RequestType.CHOOSER;
        }
        if (requestType != null) {
            try {
                if (resultCode == -1) {
                    Uri uriD = mediaPicker.d(contextRequireContext, requestType, data);
                    contextRequireContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uriD));
                    cVar.b(uriD, requestType);
                } else {
                    if (resultCode == 0) {
                        return;
                    }
                    throw new IOException("Bad activity result code: " + resultCode + ", for request code: " + requestCode);
                }
            } catch (IOException e2) {
                cVar.a(e2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            String name = getClass().getName();
            Intrinsics3.checkNotNullExpressionValue(name, "javaClass.name");
            Intrinsics3.checkNotNullParameter(name, "key");
            Collection<HashMap<String, Function0<Boolean>>> collectionValues = appActivity.l.values();
            Intrinsics3.checkNotNullExpressionValue(collectionValues, "backPressHandlers\n        .values");
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                ((HashMap) it.next()).remove(name);
            }
        }
        TextWatcher.INSTANCE.reset(this);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            Intrinsics3.checkNotNullParameter(this, "fragmentOwner");
            appActivity.newIntentListeners.remove(Integer.valueOf(getId()));
        }
        super.onDetach();
    }

    public void onImageChosen(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
    }

    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        getUnsubscribeSignal().onNext(null);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.onViewBoundOrOnResumeInvoked) {
            this.onViewBoundOrOnResumeInvoked = false;
        } else {
            onViewBoundOrOnResume();
        }
    }

    @CallSuper
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
    }

    @CallSuper
    public void onViewBoundOrOnResume() {
        getAppLogger().b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            bindToolbar(appActivity, view);
        }
        this.isRecreated = savedInstanceState != null;
        DisplayUtils.drawUnderSystemBars(view);
        onViewBound(view);
        onViewBoundOrOnResume();
        this.onViewBoundOrOnResumeInvoked = true;
    }

    public final void openMediaChooser() {
        requestMedia(new d());
    }

    @Override // com.discord.app.AppPermissions2
    public void requestCameraQRScanner(Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestCameraQRScanner(onSuccess, onFailure);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestContacts(Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics3.checkNotNullParameter(onFailure, "onFailure");
        requireAppActivity().appPermissions.requestContacts(onSuccess, onFailure);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestMedia(Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestMedia(onSuccess);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestMediaDownload(Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestMediaDownload(onSuccess);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestMicrophone(Function0<Unit> onFailure, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestMicrophone(onFailure, onSuccess);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestVideoCallPermissions(Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestVideoCallPermissions(onSuccess);
    }

    public final AppActivity requireAppActivity() {
        AppActivity appActivity = getAppActivity();
        Intrinsics3.checkNotNull(appActivity);
        return appActivity;
    }

    public final Toolbar setActionBarDisplayHomeAsUpEnabled() {
        return setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
    }

    public final Toolbar setActionBarDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        AppActivity appActivity = getAppActivity();
        if (appActivity == null) {
            return null;
        }
        boolean z2 = AppActivity.m;
        return appActivity.k(showHomeAsUp, null, null);
    }

    public final Toolbar setActionBarOptionsMenu(@MenuRes int i, Action2<MenuItem, Context> action2) {
        return setActionBarOptionsMenu$default(this, i, action2, null, 4, null);
    }

    public final Toolbar setActionBarOptionsMenu(@MenuRes int menuResId, Action2<MenuItem, Context> onSelected, Action1<Menu> onConfigured) {
        Toolbar toolbar;
        AppActivity appActivity = getAppActivity();
        if (appActivity == null || (toolbar = appActivity.toolbar) == null) {
            return null;
        }
        Menu menu = toolbar.getMenu();
        if (menu != null) {
            menu.clear();
        }
        toolbar.inflateMenu(menuResId);
        toolbar.setOnMenuItemClickListener(new AppActivity2(toolbar, menuResId, onSelected, onConfigured));
        Menu menu2 = toolbar.getMenu();
        if (menu2 != null && onConfigured != null) {
            onConfigured.call(menu2);
        }
        return toolbar;
    }

    public final Unit setActionBarSubtitle(CharSequence subtitle) {
        ToolbarTitleLayout toolbarTitleLayoutE;
        AppActivity appActivity = getAppActivity();
        if (appActivity == null || (toolbarTitleLayoutE = appActivity.e()) == null) {
            return null;
        }
        toolbarTitleLayoutE.setSubtitle(subtitle);
        return Unit.a;
    }

    public final Unit setActionBarTitle(CharSequence title) {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            return appActivity.l(title, null);
        }
        return null;
    }

    public final Unit setActionBarTitleAccessibilityViewFocused() {
        ToolbarTitleLayout toolbarTitleLayoutE;
        AppActivity appActivity = getAppActivity();
        if (appActivity == null || (toolbarTitleLayoutE = appActivity.e()) == null) {
            return null;
        }
        toolbarTitleLayoutE.sendAccessibilityEvent(8);
        return Unit.a;
    }

    public final Unit setActionBarTitleClick(View.OnClickListener onClickListener) {
        Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
        AppActivity appActivity = getAppActivity();
        if (appActivity == null) {
            return null;
        }
        Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
        ToolbarTitleLayout toolbarTitleLayoutE = appActivity.e();
        if (toolbarTitleLayoutE == null) {
            return null;
        }
        toolbarTitleLayoutE.setOnClickListener(onClickListener);
        return Unit.a;
    }

    public final Unit setActionBarTitleColor(@ColorInt int color) {
        ToolbarTitleLayout toolbarTitleLayoutE;
        AppActivity appActivity = getAppActivity();
        if (appActivity == null || (toolbarTitleLayoutE = appActivity.e()) == null) {
            return null;
        }
        toolbarTitleLayoutE.setTitleColor(color);
        return Unit.a;
    }

    public final Unit setActionBarTitleLayoutExpandedTappableArea() {
        AppActivity appActivity = getAppActivity();
        if (appActivity == null) {
            return null;
        }
        ToolbarTitleLayout toolbarTitleLayoutE = appActivity.e();
        if (toolbarTitleLayoutE != null) {
            toolbarTitleLayoutE.setLayoutParams(new Toolbar.LayoutParams(-1, -1));
        }
        return Unit.a;
    }

    public final Unit setActionBarTitleLayoutMinimumTappableArea() {
        AppActivity appActivity = getAppActivity();
        if (appActivity == null) {
            return null;
        }
        ToolbarTitleLayout toolbarTitleLayoutE = appActivity.e();
        if (toolbarTitleLayoutE != null) {
            toolbarTitleLayoutE.setLayoutParams(new Toolbar.LayoutParams(-2, -2));
        }
        return Unit.a;
    }

    public final void setOnBackPressed(Func0<Boolean> func0) {
        setOnBackPressed$default(this, func0, 0, 2, null);
    }

    public final void setOnBackPressed(Func0<Boolean> onBackAction, int priority) {
        Intrinsics3.checkNotNullParameter(onBackAction, "onBackAction");
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            e eVar = new e(onBackAction);
            String name = getClass().getName();
            Intrinsics3.checkNotNullExpressionValue(name, "javaClass.name");
            Intrinsics3.checkNotNullParameter(eVar, "handler");
            Intrinsics3.checkNotNullParameter(name, "key");
            HashMap<String, Function0<Boolean>> map = appActivity.l.get(Integer.valueOf(priority));
            if (map == null) {
                map = new HashMap<>();
            }
            map.put(name, eVar);
            appActivity.l.put(Integer.valueOf(priority), map);
        }
    }

    public final void setOnNewIntentListener(Function1<? super Intent, Unit> action) {
        Intrinsics3.checkNotNullParameter(action, "action");
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            Intrinsics3.checkNotNullParameter(this, "fragmentOwner");
            Intrinsics3.checkNotNullParameter(action, "action");
            appActivity.newIntentListeners.put(Integer.valueOf(getId()), action);
        }
    }

    public void showKeyboard(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.showKeyboard(view);
        }
    }

    private final Unit bindToolbar(AppActivity appActivity, View view) {
        Toolbar toolbar;
        if (view == null || (toolbar = (Toolbar) view.findViewById(R.id.action_bar_toolbar)) == null) {
            return null;
        }
        if (!Intrinsics3.areEqual(appActivity.toolbar, toolbar)) {
            appActivity.n(toolbar);
        }
        return Unit.a;
    }

    public final Unit setActionBarTitle(CharSequence title, @DrawableRes Integer leftDrawable) {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            return appActivity.l(title, leftDrawable);
        }
        return null;
    }

    public static /* synthetic */ Toolbar setActionBarDisplayHomeAsUpEnabled$default(AppFragment appFragment, boolean z2, Integer num, Integer num2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z2 = true;
            }
            return appFragment.setActionBarDisplayHomeAsUpEnabled(z2, num, num2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setActionBarDisplayHomeAsUpEnabled");
    }

    public final Unit setActionBarSubtitle(@StringRes int subtitleResId) {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            String string = getString(subtitleResId);
            ToolbarTitleLayout toolbarTitleLayoutE = appActivity.e();
            if (toolbarTitleLayoutE != null) {
                toolbarTitleLayoutE.setSubtitle(string);
                return Unit.a;
            }
        }
        return null;
    }

    public final void setActionBarTitle(CharSequence title, @DrawableRes Integer leftDrawable, @DrawableRes Integer trailingDrawable) {
        ToolbarTitleLayout toolbarTitleLayoutE;
        AppActivity appActivity = getAppActivity();
        if (appActivity == null || (toolbarTitleLayoutE = appActivity.e()) == null) {
            return;
        }
        toolbarTitleLayoutE.a(title, leftDrawable, trailingDrawable);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestCameraQRScanner(Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestCameraQRScanner(onSuccess);
    }

    public final Toolbar setActionBarDisplayHomeAsUpEnabled(boolean showHomeAsUp, @DrawableRes Integer iconRes, @StringRes Integer iconAccessibilityLabel) {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            return appActivity.k(showHomeAsUp, iconRes, iconAccessibilityLabel);
        }
        return null;
    }

    public AppFragment(@LayoutRes int i) {
        super(i);
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
        this.fileManager = LazyJVM.lazy(new b());
        this.appLogger = LazyJVM.lazy(new a());
    }

    public final Unit setActionBarTitle(@StringRes int titleResId) {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            return appActivity.l(getString(titleResId), null);
        }
        return null;
    }
}
