package com.discord.widgets.chat.list;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources$Theme;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.m;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.PublishMessageDialogBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.notice.WidgetNoticeDialog$ActionLinkMovementMethod;
import com.google.android.material.button.MaterialButton;
import d0.z.d.a0;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: PublishActionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PublishActionDialog extends AppDialog {
    private static final String ARG_THEME_ID = "theme_id";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function0<Unit> onSuccess;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(PublishActionDialog.class, "binding", "getBinding()Lcom/discord/databinding/PublishMessageDialogBinding;", 0)};
    public static final PublishActionDialog$Companion Companion = new PublishActionDialog$Companion(null);

    public PublishActionDialog() {
        super(R$layout.publish_message_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, PublishActionDialog$binding$2.INSTANCE, null, 2, null);
        PublishActionDialog$viewModel$2 publishActionDialog$viewModel$2 = new PublishActionDialog$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(PublishActionDialogViewModel.class), new PublishActionDialog$appViewModels$$inlined$viewModels$1(g0Var), new i0(publishActionDialog$viewModel$2));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(PublishActionDialog publishActionDialog) {
        return publishActionDialog.getArgumentsOrDefault();
    }

    public static final /* synthetic */ Function0 access$getOnSuccess$p(PublishActionDialog publishActionDialog) {
        return publishActionDialog.onSuccess;
    }

    public static final /* synthetic */ PublishActionDialogViewModel access$getViewModel$p(PublishActionDialog publishActionDialog) {
        return publishActionDialog.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(PublishActionDialog publishActionDialog, PublishActionDialogViewModel$Event publishActionDialogViewModel$Event) {
        publishActionDialog.handleEvent(publishActionDialogViewModel$Event);
    }

    public static final /* synthetic */ void access$setOnSuccess$p(PublishActionDialog publishActionDialog, Function0 function0) {
        publishActionDialog.onSuccess = function0;
    }

    public static final /* synthetic */ void access$updateView(PublishActionDialog publishActionDialog, PublishActionDialogViewModel$ViewState publishActionDialogViewModel$ViewState) {
        publishActionDialog.updateView(publishActionDialogViewModel$ViewState);
    }

    private final PublishMessageDialogBinding getBinding() {
        return (PublishMessageDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final PublishActionDialogViewModel getViewModel() {
        return (PublishActionDialogViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(PublishActionDialogViewModel$Event event) {
        if (event instanceof PublishActionDialogViewModel$Event$Success) {
            m.i(this, 2131892965, 0, 4);
        } else if (event instanceof PublishActionDialogViewModel$Event$Failure) {
            m.i(this, 2131894630, 0, 4);
        }
        dismiss();
    }

    private final void renderHasFollowers(PublishActionDialogViewModel$ViewState$LoadedHasFollowers viewState) {
        TextView textView = getBinding().f2137b;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.noticeBodyText");
        b.n(textView, 2131894626, new Object[]{String.valueOf(viewState.getFollowerStats().getGuildsFollowing())}, null, 4);
    }

    private final void renderLoading() {
        TextView textView = getBinding().f2137b;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.noticeBodyText");
        b.n(textView, 2131892565, new Object[0], null, 4);
    }

    private final void renderNoFollowers() {
        TextView textView = getBinding().f2137b;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.noticeBodyText");
        b.n(textView, 2131894625, new Object[0], null, 4);
    }

    public static final void show(FragmentManager fragmentManager, long j, long j2, Function0<Unit> function0, Integer num) {
        Companion.show(fragmentManager, j, j2, function0, num);
    }

    private final void updateView(PublishActionDialogViewModel$ViewState viewState) {
        if (d0.z.d.m.areEqual(viewState, PublishActionDialogViewModel$ViewState$Loading.INSTANCE)) {
            renderLoading();
        } else if (d0.z.d.m.areEqual(viewState, PublishActionDialogViewModel$ViewState$LoadedNoFollowers.INSTANCE)) {
            renderNoFollowers();
        } else if (viewState instanceof PublishActionDialogViewModel$ViewState$LoadedHasFollowers) {
            renderHasFollowers((PublishActionDialogViewModel$ViewState$LoadedHasFollowers) viewState);
        }
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Resources$Theme theme;
        Bundle arguments = getArguments();
        if (arguments != null) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context != null && (theme = context.getTheme()) != null) {
                theme.resolveAttribute(arguments.getInt(ARG_THEME_ID, 2130969241), typedValue, true);
            }
            setStyle(1, typedValue.resourceId);
        }
        return super.onCreateDialog(savedInstanceState);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().d;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.noticeHeader");
        b.n(textView, 2131893210, new Object[0], null, 4);
        LinearLayout linearLayout = getBinding().e;
        d0.z.d.m.checkNotNullExpressionValue(linearLayout, "binding.noticeHeaderContainer");
        linearLayout.setVisibility(0);
        TextView textView2 = getBinding().f2137b;
        d0.z.d.m.checkNotNullExpressionValue(textView2, "binding.noticeBodyText");
        textView2.setTextAlignment(2);
        TextView textView3 = getBinding().f2137b;
        d0.z.d.m.checkNotNullExpressionValue(textView3, "binding.noticeBodyText");
        textView3.setMovementMethod(new WidgetNoticeDialog$ActionLinkMovementMethod(new PublishActionDialog$onViewBound$1(this)));
        MaterialButton materialButton = getBinding().f;
        d0.z.d.m.checkNotNullExpressionValue(materialButton, "binding.noticeOk");
        ViewExtensions.setTextAndVisibilityBy(materialButton, b.k(this, 2131893209, new Object[0], null, 4));
        getBinding().f.setOnClickListener(new PublishActionDialog$onViewBound$2(this));
        MaterialButton materialButton2 = getBinding().c;
        d0.z.d.m.checkNotNullExpressionValue(materialButton2, "binding.noticeCancel");
        ViewExtensions.setTextAndVisibilityBy(materialButton2, b.k(this, 2131887437, new Object[0], null, 4));
        getBinding().c.setOnClickListener(new PublishActionDialog$onViewBound$3(this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), PublishActionDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new PublishActionDialog$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), PublishActionDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new PublishActionDialog$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
