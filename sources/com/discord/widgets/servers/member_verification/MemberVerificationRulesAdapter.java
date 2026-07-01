package com.discord.widgets.servers.member_verification;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.app.AppFragment;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationRulesAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {
    private final AppFragment fragment;
    private Function1<? super Boolean, Unit> onUpdateRulesApproval;
    private Function2<? super Integer, Object, Unit> onUserInputDataEntered;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationRulesAdapter(RecyclerView recyclerView, AppFragment appFragment) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(appFragment, "fragment");
        this.fragment = appFragment;
        this.onUpdateRulesApproval = MemberVerificationRulesAdapter$onUpdateRulesApproval$1.INSTANCE;
        this.onUserInputDataEntered = MemberVerificationRulesAdapter$onUserInputDataEntered$1.INSTANCE;
    }

    public final AppFragment getFragment() {
        return this.fragment;
    }

    public final Function1<Boolean, Unit> getOnUpdateRulesApproval() {
        return this.onUpdateRulesApproval;
    }

    public final Function2<Integer, Object, Unit> getOnUserInputDataEntered() {
        return this.onUserInputDataEntered;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnUpdateRulesApproval(Function1<? super Boolean, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onUpdateRulesApproval = function1;
    }

    public final void setOnUserInputDataEntered(Function2<? super Integer, Object, Unit> function2) {
        m.checkNotNullParameter(function2, "<set-?>");
        this.onUserInputDataEntered = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                return new MemberVerificationRulesAdapter$ItemHolder(this);
            case 1:
                return new MemberVerificationRulesAdapter$TermHeaderItemHolder(this);
            case 2:
                return new MemberVerificationRulesAdapter$ApproveTermsItemHolder(this);
            case 3:
                return new MemberVerificationRulesAdapter$TermItemHolder(this);
            case 4:
                return new MemberVerificationRulesAdapter$TextInputItemHolder(this);
            case 5:
                return new MemberVerificationRulesAdapter$ParagraphItemHolder(this);
            case 6:
                return new MemberVerificationRulesAdapter$MultipleChoiceItemHolder(this);
            default:
                throw invalidViewTypeException(viewType);
        }
    }
}
