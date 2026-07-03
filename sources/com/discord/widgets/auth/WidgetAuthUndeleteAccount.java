package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetAuthUndeleteAccountBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.ScreenTitleView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetAuthUndeleteAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthUndeleteAccount extends AppFragment {
    private static final String ARG_DISABLED_KEY = "ARG_DISABLED_KEY";
    private static final String RESULT_EXTRA_UNDELETE = "RESULT_EXTRA_UNDELETE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetAuthUndeleteAccount.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthUndeleteAccountBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetAuthUndeleteAccount.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, boolean disabled) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(launcher, "launcher");
            Intent intentPutExtra = new Intent().putExtra(WidgetAuthUndeleteAccount.ARG_DISABLED_KEY, disabled);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(ARG_DISABLED_KEY, disabled)");
            C0870j.f524g.m160f(context, launcher, WidgetAuthUndeleteAccount.class, intentPutExtra);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, final Function0<Unit> callback) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.auth.WidgetAuthUndeleteAccount$Companion$registerForResult$1
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(ActivityResult activityResult) {
                    C12238m.checkNotNullExpressionValue(activityResult, "activityResult");
                    Intent data = activityResult.getData();
                    if (data != null ? data.getBooleanExtra("RESULT_EXTRA_UNDELETE", false) : false) {
                        callback.invoke();
                    }
                }
            });
            C12238m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetAuthUndeleteAccount() {
        super(C5419R.layout.widget_auth_undelete_account);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthUndeleteAccount$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetAuthUndeleteAccountBinding getBinding() {
        return (WidgetAuthUndeleteAccountBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        if (getMostRecentIntent().getBooleanExtra(ARG_DISABLED_KEY, false)) {
            ScreenTitleView screenTitleView = getBinding().f15722d;
            String string = getString(C5419R.string.account_disabled_title);
            C12238m.checkNotNullExpressionValue(string, "getString(R.string.account_disabled_title)");
            screenTitleView.setTitle(string);
            getBinding().f15722d.setSubtitle(getString(C5419R.string.account_disabled_description));
        } else {
            ScreenTitleView screenTitleView2 = getBinding().f15722d;
            String string2 = getString(C5419R.string.account_scheduled_for_deletion_title);
            C12238m.checkNotNullExpressionValue(string2, "getString(R.string.accou…duled_for_deletion_title)");
            screenTitleView2.setTitle(string2);
            getBinding().f15722d.setSubtitle(getString(C5419R.string.account_scheduled_for_deletion_description));
        }
        getBinding().f15721c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthUndeleteAccount.onViewBoundOrOnResume.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12238m.checkNotNullExpressionValue(view, "it");
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                C0870j.m155c(context, false, null, 4);
            }
        });
        getBinding().f15720b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthUndeleteAccount.onViewBoundOrOnResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(WidgetAuthUndeleteAccount.RESULT_EXTRA_UNDELETE, true);
                AppActivity appActivity = WidgetAuthUndeleteAccount.this.getAppActivity();
                if (appActivity != null) {
                    appActivity.setResult(-1, intent);
                }
                AppActivity appActivity2 = WidgetAuthUndeleteAccount.this.getAppActivity();
                if (appActivity2 != null) {
                    appActivity2.finish();
                }
            }
        });
    }
}
