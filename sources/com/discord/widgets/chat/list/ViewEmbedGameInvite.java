package com.discord.widgets.chat.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivityParty;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.databinding.ViewChatEmbedGameInviteBinding;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.list.WidgetCollapsedUsersListAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ViewEmbedGameInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewEmbedGameInvite extends LinearLayout {
    public static final ViewEmbedGameInvite$Companion Companion = new ViewEmbedGameInvite$Companion(null);
    private static final long EMBED_LIFETIME_MILLIS = 7200000;
    private static final long MAX_USERS_SHOWN = 4;
    private final ViewChatEmbedGameInviteBinding binding;
    private Function2<? super View, ? super ViewEmbedGameInvite$Model, Unit> onActionButtonClick;
    private final WidgetCollapsedUsersListAdapter userAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewEmbedGameInvite(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        ViewChatEmbedGameInviteBinding viewChatEmbedGameInviteBindingA = ViewChatEmbedGameInviteBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewChatEmbedGameInviteBindingA, "ViewChatEmbedGameInviteB…ater.from(context), this)");
        this.binding = viewChatEmbedGameInviteBindingA;
        setOrientation(1);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = viewChatEmbedGameInviteBindingA.h;
        m.checkNotNullExpressionValue(recyclerView, "binding.itemGameInviteRecycler");
        this.userAdapter = (WidgetCollapsedUsersListAdapter) mGRecyclerAdapter$Companion.configure(new WidgetCollapsedUsersListAdapter(recyclerView));
    }

    private final void configureActivityImages(ViewEmbedGameInvite$Model viewEmbedGameInvite$Model, boolean z2) {
        String smallImage;
        SimpleDraweeView simpleDraweeView = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemGameInviteAvatarIv");
        String icon = viewEmbedGameInvite$Model.getApplication().getIcon();
        MGImages.setImage$default(simpleDraweeView, icon != null ? IconUtils.getApplicationIcon$default(viewEmbedGameInvite$Model.getApplication().getId(), icon, 0, 4, (Object) null) : null, 0, 0, false, null, null, 124, null);
        Activity activity = viewEmbedGameInvite$Model.getActivity();
        ActivityAssets assets = activity != null ? activity.getAssets() : null;
        SimpleDraweeView simpleDraweeView2 = this.binding.e;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemGameInviteAvatarStatusIv");
        simpleDraweeView2.setVisibility((assets != null ? assets.getSmallImage() : null) != null ? 0 : 8);
        SimpleDraweeView simpleDraweeView3 = this.binding.e;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemGameInviteAvatarStatusIv");
        MGImages.setImage$default(simpleDraweeView3, (assets == null || (smallImage = assets.getSmallImage()) == null) ? null : IconUtils.getAssetImage$default(IconUtils.INSTANCE, Long.valueOf(viewEmbedGameInvite$Model.getApplication().getId()), smallImage, 0, 4, null), 0, 0, false, null, null, 124, null);
        SimpleDraweeView simpleDraweeView4 = this.binding.e;
        m.checkNotNullExpressionValue(simpleDraweeView4, "binding.itemGameInviteAvatarStatusIv");
        simpleDraweeView4.setContentDescription(assets != null ? assets.getSmallText() : null);
        if (z2) {
            SimpleDraweeView simpleDraweeView5 = this.binding.f;
            m.checkNotNullExpressionValue(simpleDraweeView5, "binding.itemGameInviteCoverIv");
            simpleDraweeView5.setVisibility(8);
            SimpleDraweeView simpleDraweeView6 = this.binding.f;
            m.checkNotNullExpressionValue(simpleDraweeView6, "binding.itemGameInviteCoverIv");
            MGImages.setImage$default(simpleDraweeView6, null, 0, 0, false, null, null, 124, null);
            return;
        }
        SimpleDraweeView simpleDraweeView7 = this.binding.f;
        m.checkNotNullExpressionValue(simpleDraweeView7, "binding.itemGameInviteCoverIv");
        simpleDraweeView7.setVisibility(0);
        String largeImage = assets != null ? assets.getLargeImage() : null;
        if (largeImage != null) {
            SimpleDraweeView simpleDraweeView8 = this.binding.f;
            m.checkNotNullExpressionValue(simpleDraweeView8, "binding.itemGameInviteCoverIv");
            simpleDraweeView8.setContentDescription(assets.getLargeText());
            SimpleDraweeView simpleDraweeView9 = this.binding.f;
            m.checkNotNullExpressionValue(simpleDraweeView9, "binding.itemGameInviteCoverIv");
            simpleDraweeView9.setImportantForAccessibility(1);
            String assetImage = IconUtils.INSTANCE.getAssetImage(Long.valueOf(viewEmbedGameInvite$Model.getApplication().getId()), largeImage, IconUtils.getMediaProxySize(getWidth()));
            SimpleDraweeView simpleDraweeView10 = this.binding.f;
            m.checkNotNullExpressionValue(simpleDraweeView10, "binding.itemGameInviteCoverIv");
            MGImages.setImage$default(simpleDraweeView10, assetImage, 0, 0, false, null, null, 124, null);
            return;
        }
        SimpleDraweeView simpleDraweeView11 = this.binding.f;
        m.checkNotNullExpressionValue(simpleDraweeView11, "binding.itemGameInviteCoverIv");
        simpleDraweeView11.setImportantForAccessibility(2);
        SimpleDraweeView simpleDraweeView12 = this.binding.f;
        m.checkNotNullExpressionValue(simpleDraweeView12, "binding.itemGameInviteCoverIv");
        simpleDraweeView12.setContentDescription(null);
        String coverImage = viewEmbedGameInvite$Model.getApplication().getCoverImage();
        String applicationIcon$default = coverImage != null ? IconUtils.getApplicationIcon$default(viewEmbedGameInvite$Model.getApplication().getId(), coverImage, 0, 4, (Object) null) : null;
        SimpleDraweeView simpleDraweeView13 = this.binding.f;
        m.checkNotNullExpressionValue(simpleDraweeView13, "binding.itemGameInviteCoverIv");
        MGImages.setImage$default(simpleDraweeView13, applicationIcon$default, 0, 0, false, null, null, 124, null);
    }

    private final void configureUI(ViewEmbedGameInvite$Model viewEmbedGameInvite$Model, Clock clock) {
        Activity activity;
        ActivityParty party;
        boolean zIsDeadInvite = viewEmbedGameInvite$Model.isDeadInvite(clock.currentTimeMillis());
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.itemGameInviteApplicationNameTv");
        textView.setText(viewEmbedGameInvite$Model.getApplication().getName());
        TextView textView2 = this.binding.g;
        int i = 2131892258;
        if (!zIsDeadInvite && viewEmbedGameInvite$Model.getMessageActivity().getType() != MessageActivityType.SPECTATE) {
            i = 2131892262;
        }
        textView2.setText(i);
        boolean z2 = ((!zIsDeadInvite && (activity = viewEmbedGameInvite$Model.getActivity()) != null && (party = activity.getParty()) != null) ? PresenceUtils.INSTANCE.getNumOpenSlots(party) : 0L) <= 0;
        TextView textView3 = this.binding.i;
        m.checkNotNullExpressionValue(textView3, "binding.itemGameInviteSubtext");
        String state = null;
        if (z2) {
            Activity activity2 = viewEmbedGameInvite$Model.getActivity();
            if (activity2 != null) {
                state = activity2.getDetails();
            }
        } else {
            Activity activity3 = viewEmbedGameInvite$Model.getActivity();
            if (activity3 != null) {
                state = activity3.getState();
            }
        }
        ViewExtensions.setTextAndVisibilityBy(textView3, state);
        configureActivityImages(viewEmbedGameInvite$Model, zIsDeadInvite);
        onConfigureActionButton(viewEmbedGameInvite$Model, zIsDeadInvite, z2);
        RecyclerView recyclerView = this.binding.h;
        m.checkNotNullExpressionValue(recyclerView, "binding.itemGameInviteRecycler");
        recyclerView.setVisibility(zIsDeadInvite ^ true ? 0 : 8);
        if (zIsDeadInvite) {
            return;
        }
        this.userAdapter.setData(viewEmbedGameInvite$Model.getUsers());
    }

    private final void onConfigureActionButton(ViewEmbedGameInvite$Model viewEmbedGameInvite$Model, boolean z2, boolean z3) {
        MaterialButton materialButton = this.binding.f2177b;
        m.checkNotNullExpressionValue(materialButton, "binding.itemGameInviteActionBtn");
        boolean z4 = false;
        materialButton.setVisibility(0);
        int i = 2131892378;
        if (z2 || !viewEmbedGameInvite$Model.getCanJoin()) {
            MaterialButton materialButton2 = this.binding.f2177b;
            m.checkNotNullExpressionValue(materialButton2, "binding.itemGameInviteActionBtn");
            materialButton2.setEnabled(false);
            this.binding.f2177b.setText(2131892378);
            return;
        }
        MaterialButton materialButton3 = this.binding.f2177b;
        m.checkNotNullExpressionValue(materialButton3, "binding.itemGameInviteActionBtn");
        if (!viewEmbedGameInvite$Model.getIsInParty() && !z3 && viewEmbedGameInvite$Model.getCreatorId() != viewEmbedGameInvite$Model.getMeUser().getId()) {
            z4 = true;
        }
        materialButton3.setEnabled(z4);
        MaterialButton materialButton4 = this.binding.f2177b;
        if (z3) {
            i = 2131892257;
        } else if (viewEmbedGameInvite$Model.getIsInParty()) {
            i = 2131892269;
        }
        materialButton4.setText(i);
        this.binding.f2177b.setOnClickListener(new ViewEmbedGameInvite$onConfigureActionButton$1(this, viewEmbedGameInvite$Model));
    }

    public final void bind(ViewEmbedGameInvite$Model model, Clock clock) {
        m.checkNotNullParameter(model, "model");
        m.checkNotNullParameter(clock, "clock");
        configureUI(model, clock);
    }

    public final Function2<View, ViewEmbedGameInvite$Model, Unit> getOnActionButtonClick() {
        return this.onActionButtonClick;
    }

    public final void setOnActionButtonClick(Function2<? super View, ? super ViewEmbedGameInvite$Model, Unit> function2) {
        this.onActionButtonClick = function2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewEmbedGameInvite(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        ViewChatEmbedGameInviteBinding viewChatEmbedGameInviteBindingA = ViewChatEmbedGameInviteBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewChatEmbedGameInviteBindingA, "ViewChatEmbedGameInviteB…ater.from(context), this)");
        this.binding = viewChatEmbedGameInviteBindingA;
        setOrientation(1);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = viewChatEmbedGameInviteBindingA.h;
        m.checkNotNullExpressionValue(recyclerView, "binding.itemGameInviteRecycler");
        this.userAdapter = (WidgetCollapsedUsersListAdapter) mGRecyclerAdapter$Companion.configure(new WidgetCollapsedUsersListAdapter(recyclerView));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewEmbedGameInvite(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        ViewChatEmbedGameInviteBinding viewChatEmbedGameInviteBindingA = ViewChatEmbedGameInviteBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewChatEmbedGameInviteBindingA, "ViewChatEmbedGameInviteB…ater.from(context), this)");
        this.binding = viewChatEmbedGameInviteBindingA;
        setOrientation(1);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = viewChatEmbedGameInviteBindingA.h;
        m.checkNotNullExpressionValue(recyclerView, "binding.itemGameInviteRecycler");
        this.userAdapter = (WidgetCollapsedUsersListAdapter) mGRecyclerAdapter$Companion.configure(new WidgetCollapsedUsersListAdapter(recyclerView));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewEmbedGameInvite(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m.checkNotNullParameter(context, "context");
        ViewChatEmbedGameInviteBinding viewChatEmbedGameInviteBindingA = ViewChatEmbedGameInviteBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewChatEmbedGameInviteBindingA, "ViewChatEmbedGameInviteB…ater.from(context), this)");
        this.binding = viewChatEmbedGameInviteBindingA;
        setOrientation(1);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = viewChatEmbedGameInviteBindingA.h;
        m.checkNotNullExpressionValue(recyclerView, "binding.itemGameInviteRecycler");
        this.userAdapter = (WidgetCollapsedUsersListAdapter) mGRecyclerAdapter$Companion.configure(new WidgetCollapsedUsersListAdapter(recyclerView));
    }
}
