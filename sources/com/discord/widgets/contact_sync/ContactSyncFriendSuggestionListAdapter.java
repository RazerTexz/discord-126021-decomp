package com.discord.widgets.contact_sync;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.api.friendsuggestions.FriendSuggestionReason;
import com.discord.api.user.User;
import com.discord.databinding.ViewSelectableFriendSuggestionBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.contact_sync.ContactSyncFriendSuggestionListAdapter;
import com.discord.widgets.contact_sync.WidgetContactSyncViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.checkbox.MaterialCheckBox;
import d0.g0.StringNumberConversions;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ContactSyncFriendSuggestionListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncFriendSuggestionListAdapter extends MGRecyclerAdapterSimple<WidgetContactSyncViewModel.Item> {
    private Function2<? super Long, ? super Boolean, Unit> onClickFriendSuggestion;
    private final int spacing;

    /* JADX INFO: compiled from: ContactSyncFriendSuggestionListAdapter.kt */
    public static final class ItemFriendSuggestion extends MGRecyclerViewHolder<ContactSyncFriendSuggestionListAdapter, WidgetContactSyncViewModel.Item> {
        private final ViewSelectableFriendSuggestionBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemFriendSuggestion(ContactSyncFriendSuggestionListAdapter contactSyncFriendSuggestionListAdapter) {
            super(R.layout.view_selectable_friend_suggestion, contactSyncFriendSuggestionListAdapter);
            Intrinsics3.checkNotNullParameter(contactSyncFriendSuggestionListAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.friend_suggestion_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.friend_suggestion_avatar);
            if (simpleDraweeView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.friend_suggestion_discriminator;
                TextView textView = (TextView) view.findViewById(R.id.friend_suggestion_discriminator);
                if (textView != null) {
                    i = R.id.friend_suggestion_name;
                    TextView textView2 = (TextView) view.findViewById(R.id.friend_suggestion_name);
                    if (textView2 != null) {
                        i = R.id.friend_suggestion_nickname;
                        TextView textView3 = (TextView) view.findViewById(R.id.friend_suggestion_nickname);
                        if (textView3 != null) {
                            i = R.id.friend_suggestion_selected;
                            MaterialCheckBox materialCheckBox = (MaterialCheckBox) view.findViewById(R.id.friend_suggestion_selected);
                            if (materialCheckBox != null) {
                                ViewSelectableFriendSuggestionBinding viewSelectableFriendSuggestionBinding = new ViewSelectableFriendSuggestionBinding(constraintLayout, simpleDraweeView, constraintLayout, textView, textView2, textView3, materialCheckBox);
                                Intrinsics3.checkNotNullExpressionValue(viewSelectableFriendSuggestionBinding, "ViewSelectableFriendSugg…ionBinding.bind(itemView)");
                                this.binding = viewSelectableFriendSuggestionBinding;
                                return;
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ ContactSyncFriendSuggestionListAdapter access$getAdapter$p(ItemFriendSuggestion itemFriendSuggestion) {
            return (ContactSyncFriendSuggestionListAdapter) itemFriendSuggestion.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        @SuppressLint({"SetTextI18n"})
        public void onConfigure(int position, WidgetContactSyncViewModel.Item data) {
            Object next;
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            WidgetContactSyncViewModel.Item.FriendSuggestionItem friendSuggestionItem = (WidgetContactSyncViewModel.Item.FriendSuggestionItem) data;
            FriendSuggestion suggestion = friendSuggestionItem.getSuggestion();
            User suggestedUser = suggestion.getSuggestedUser();
            ConstraintLayout constraintLayout = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.friendSuggestionContainer");
            int paddingLeft = constraintLayout.getPaddingLeft();
            ConstraintLayout constraintLayout2 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.friendSuggestionContainer");
            constraintLayout.setPadding(paddingLeft, 0, constraintLayout2.getPaddingRight(), ((ContactSyncFriendSuggestionListAdapter) this.adapter).spacing);
            TextView textView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.friendSuggestionName");
            textView.setText(suggestedUser.getUsername());
            TextView textView2 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.friendSuggestionDiscriminator");
            textView2.setText(MentionUtils.CHANNELS_CHAR + suggestedUser.getDiscriminator());
            Iterator<T> it = suggestion.a().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics3.areEqual(((FriendSuggestionReason) next).getPlatformType(), "contacts"));
            FriendSuggestionReason friendSuggestionReason = (FriendSuggestionReason) next;
            String name = friendSuggestionReason != null ? friendSuggestionReason.getName() : null;
            if (name == null) {
                TextView textView3 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.friendSuggestionNickname");
                textView3.setVisibility(8);
            } else {
                TextView textView4 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.friendSuggestionNickname");
                textView4.setText(name);
                TextView textView5 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(textView5, "binding.friendSuggestionNickname");
                textView5.setVisibility(StringsJVM.isBlank(name) ^ true ? 0 : 8);
            }
            MaterialCheckBox materialCheckBox = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(materialCheckBox, "binding.friendSuggestionSelected");
            materialCheckBox.setChecked(friendSuggestionItem.getSelected());
            SimpleDraweeView simpleDraweeView = this.binding.f2207b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.friendSuggestionAvatar");
            Long lValueOf = Long.valueOf(suggestedUser.getId());
            NullSerializable<String> nullSerializableA = suggestedUser.a();
            IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForUser$default(lValueOf, nullSerializableA != null ? nullSerializableA.a() : null, StringNumberConversions.toIntOrNull(suggestedUser.getDiscriminator()), false, null, 16, null), R.dimen.avatar_size_standard, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
            final long id2 = suggestion.getSuggestedUser().getId();
            this.binding.g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.discord.widgets.contact_sync.ContactSyncFriendSuggestionListAdapter$ItemFriendSuggestion$onConfigure$1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                    ContactSyncFriendSuggestionListAdapter.ItemFriendSuggestion.access$getAdapter$p(this.this$0).getOnClickFriendSuggestion().invoke(Long.valueOf(id2), Boolean.valueOf(z2));
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactSyncFriendSuggestionListAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onClickFriendSuggestion = ContactSyncFriendSuggestionListAdapter3.INSTANCE;
        Context context = recyclerView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "recycler.context");
        this.spacing = context.getResources().getDimensionPixelSize(R.dimen.suggestion_spacing);
    }

    public final Function2<Long, Boolean, Unit> getOnClickFriendSuggestion() {
        return this.onClickFriendSuggestion;
    }

    public final void setOnClickFriendSuggestion(Function2<? super Long, ? super Boolean, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "<set-?>");
        this.onClickFriendSuggestion = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, WidgetContactSyncViewModel.Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        return new ItemFriendSuggestion(this);
    }
}
