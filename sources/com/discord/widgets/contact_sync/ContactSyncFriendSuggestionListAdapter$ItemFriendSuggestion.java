package com.discord.widgets.contact_sync;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.api.friendsuggestions.FriendSuggestionReason;
import com.discord.api.user.User;
import com.discord.databinding.ViewSelectableFriendSuggestionBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.checkbox.MaterialCheckBox;
import d0.g0.s;
import d0.g0.t;
import d0.z.d.m;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ContactSyncFriendSuggestionListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncFriendSuggestionListAdapter$ItemFriendSuggestion extends MGRecyclerViewHolder<ContactSyncFriendSuggestionListAdapter, WidgetContactSyncViewModel$Item> {
    private final ViewSelectableFriendSuggestionBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactSyncFriendSuggestionListAdapter$ItemFriendSuggestion(ContactSyncFriendSuggestionListAdapter contactSyncFriendSuggestionListAdapter) {
        super(R$layout.view_selectable_friend_suggestion, contactSyncFriendSuggestionListAdapter);
        m.checkNotNullParameter(contactSyncFriendSuggestionListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.friend_suggestion_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.friend_suggestion_avatar);
        if (simpleDraweeView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R$id.friend_suggestion_discriminator;
            TextView textView = (TextView) view.findViewById(R$id.friend_suggestion_discriminator);
            if (textView != null) {
                i = R$id.friend_suggestion_name;
                TextView textView2 = (TextView) view.findViewById(R$id.friend_suggestion_name);
                if (textView2 != null) {
                    i = R$id.friend_suggestion_nickname;
                    TextView textView3 = (TextView) view.findViewById(R$id.friend_suggestion_nickname);
                    if (textView3 != null) {
                        i = R$id.friend_suggestion_selected;
                        MaterialCheckBox materialCheckBox = (MaterialCheckBox) view.findViewById(R$id.friend_suggestion_selected);
                        if (materialCheckBox != null) {
                            ViewSelectableFriendSuggestionBinding viewSelectableFriendSuggestionBinding = new ViewSelectableFriendSuggestionBinding(constraintLayout, simpleDraweeView, constraintLayout, textView, textView2, textView3, materialCheckBox);
                            m.checkNotNullExpressionValue(viewSelectableFriendSuggestionBinding, "ViewSelectableFriendSugg…ionBinding.bind(itemView)");
                            this.binding = viewSelectableFriendSuggestionBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ ContactSyncFriendSuggestionListAdapter access$getAdapter$p(ContactSyncFriendSuggestionListAdapter$ItemFriendSuggestion contactSyncFriendSuggestionListAdapter$ItemFriendSuggestion) {
        return (ContactSyncFriendSuggestionListAdapter) contactSyncFriendSuggestionListAdapter$ItemFriendSuggestion.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetContactSyncViewModel$Item widgetContactSyncViewModel$Item) {
        onConfigure2(i, widgetContactSyncViewModel$Item);
    }

    @SuppressLint({"SetTextI18n"})
    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetContactSyncViewModel$Item data) {
        Object next;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        WidgetContactSyncViewModel$Item$FriendSuggestionItem widgetContactSyncViewModel$Item$FriendSuggestionItem = (WidgetContactSyncViewModel$Item$FriendSuggestionItem) data;
        FriendSuggestion suggestion = widgetContactSyncViewModel$Item$FriendSuggestionItem.getSuggestion();
        User suggestedUser = suggestion.getSuggestedUser();
        ConstraintLayout constraintLayout = this.binding.c;
        m.checkNotNullExpressionValue(constraintLayout, "binding.friendSuggestionContainer");
        int paddingLeft = constraintLayout.getPaddingLeft();
        ConstraintLayout constraintLayout2 = this.binding.c;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.friendSuggestionContainer");
        constraintLayout.setPadding(paddingLeft, 0, constraintLayout2.getPaddingRight(), ContactSyncFriendSuggestionListAdapter.access$getSpacing$p((ContactSyncFriendSuggestionListAdapter) this.adapter));
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.friendSuggestionName");
        textView.setText(suggestedUser.getUsername());
        TextView textView2 = this.binding.d;
        m.checkNotNullExpressionValue(textView2, "binding.friendSuggestionDiscriminator");
        textView2.setText(MentionUtilsKt.CHANNELS_CHAR + suggestedUser.getDiscriminator());
        Iterator<T> it = suggestion.a().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!m.areEqual(((FriendSuggestionReason) next).getPlatformType(), "contacts"));
        FriendSuggestionReason friendSuggestionReason = (FriendSuggestionReason) next;
        String name = friendSuggestionReason != null ? friendSuggestionReason.getName() : null;
        if (name == null) {
            TextView textView3 = this.binding.f;
            m.checkNotNullExpressionValue(textView3, "binding.friendSuggestionNickname");
            textView3.setVisibility(8);
        } else {
            TextView textView4 = this.binding.f;
            m.checkNotNullExpressionValue(textView4, "binding.friendSuggestionNickname");
            textView4.setText(name);
            TextView textView5 = this.binding.f;
            m.checkNotNullExpressionValue(textView5, "binding.friendSuggestionNickname");
            textView5.setVisibility(t.isBlank(name) ^ true ? 0 : 8);
        }
        MaterialCheckBox materialCheckBox = this.binding.g;
        m.checkNotNullExpressionValue(materialCheckBox, "binding.friendSuggestionSelected");
        materialCheckBox.setChecked(widgetContactSyncViewModel$Item$FriendSuggestionItem.getSelected());
        SimpleDraweeView simpleDraweeView = this.binding.f2207b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.friendSuggestionAvatar");
        Long lValueOf = Long.valueOf(suggestedUser.getId());
        NullSerializable<String> nullSerializableA = suggestedUser.a();
        IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForUser$default(lValueOf, nullSerializableA != null ? nullSerializableA.a() : null, s.toIntOrNull(suggestedUser.getDiscriminator()), false, null, 16, null), 2131165300, (Function1) null, (MGImages$ChangeDetector) null, 24, (Object) null);
        this.binding.g.setOnCheckedChangeListener(new ContactSyncFriendSuggestionListAdapter$ItemFriendSuggestion$onConfigure$1(this, suggestion.getSuggestedUser().getId()));
    }
}
