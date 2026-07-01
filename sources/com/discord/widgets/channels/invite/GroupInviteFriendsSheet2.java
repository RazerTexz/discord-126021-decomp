package com.discord.widgets.channels.invite;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.chips_view.ChipsView;
import com.discord.databinding.GroupInviteFriendsBottomSheetBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GroupInviteFriendsSheet2 extends FunctionReferenceImpl implements Function1<View, GroupInviteFriendsBottomSheetBinding> {
    public static final GroupInviteFriendsSheet2 INSTANCE = new GroupInviteFriendsSheet2();

    public GroupInviteFriendsSheet2() {
        super(1, GroupInviteFriendsBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GroupInviteFriendsBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final GroupInviteFriendsBottomSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.chips_view;
        ChipsView chipsView = (ChipsView) view.findViewById(R.id.chips_view);
        if (chipsView != null) {
            i = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
            if (recyclerView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.search_icon;
                AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.search_icon);
                if (appCompatImageView != null) {
                    return new GroupInviteFriendsBottomSheetBinding(constraintLayout, chipsView, recyclerView, constraintLayout, appCompatImageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
