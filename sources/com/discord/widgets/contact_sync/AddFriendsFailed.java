package com.discord.widgets.contact_sync;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AddFriendsFailed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AddFriendsFailed extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(AddFriendsFailed.class, "binding", "getBinding()Lcom/discord/databinding/ViewDialogConfirmationBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function0<Unit> onClose;

    /* JADX INFO: compiled from: AddFriendsFailed.kt */
    public static final class Companion {
        private Companion() {
        }

        public final AddFriendsFailed show(FragmentManager fragmentManager) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            AddFriendsFailed addFriendsFailed = new AddFriendsFailed();
            addFriendsFailed.show(fragmentManager, AddFriendsFailed.class.getSimpleName());
            return addFriendsFailed;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AddFriendsFailed() {
        super(C5419R.layout.view_dialog_confirmation);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, AddFriendsFailed$binding$2.INSTANCE, null, 2, null);
    }

    private final ViewDialogConfirmationBinding getBinding() {
        return (ViewDialogConfirmationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final Function0<Unit> getOnClose() {
        return this.onClose;
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f15423d;
        C12238m.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationHeader");
        textView.setText(C1107b.m213e(this, C5419R.string.friend_request_failed_header, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
        TextView textView2 = getBinding().f15424e;
        C12238m.checkNotNullExpressionValue(textView2, "binding.viewDialogConfirmationText");
        textView2.setText(C1107b.m213e(this, C5419R.string.friend_request_failed_body, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
        MaterialButton materialButton = getBinding().f15422c;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.viewDialogConfirmationConfirm");
        materialButton.setText(C1107b.m213e(this, C5419R.string.okay, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
        getBinding().f15422c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.AddFriendsFailed.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddFriendsFailed.this.dismiss();
                Function0<Unit> onClose = AddFriendsFailed.this.getOnClose();
                if (onClose != null) {
                    onClose.invoke();
                }
            }
        });
        MaterialButton materialButton2 = getBinding().f15421b;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.viewDialogConfirmationCancel");
        materialButton2.setVisibility(8);
    }

    public final void setOnClose(Function0<Unit> function0) {
        this.onClose = function0;
    }
}
