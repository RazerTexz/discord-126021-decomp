package com.discord.widgets.friends;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetFriendsListContactSyncUpsellBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemContactSyncUpsell extends WidgetFriendsListAdapter$Item {
    private final WidgetFriendsListContactSyncUpsellBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsListAdapter$ItemContactSyncUpsell(WidgetFriendsListAdapter widgetFriendsListAdapter) {
        super(R$layout.widget_friends_list_contact_sync_upsell, widgetFriendsListAdapter);
        m.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.friends_list_contact_sync_upsell_arrow;
        ImageView imageView = (ImageView) view.findViewById(R$id.friends_list_contact_sync_upsell_arrow);
        if (imageView != null) {
            MaterialCardView materialCardView = (MaterialCardView) view;
            i = R$id.friends_list_contact_sync_upsell_icon;
            ImageView imageView2 = (ImageView) view.findViewById(R$id.friends_list_contact_sync_upsell_icon);
            if (imageView2 != null) {
                i = R$id.friends_list_contact_sync_upsell_subtitle;
                TextView textView = (TextView) view.findViewById(R$id.friends_list_contact_sync_upsell_subtitle);
                if (textView != null) {
                    i = R$id.friends_list_contact_sync_upsell_title;
                    TextView textView2 = (TextView) view.findViewById(R$id.friends_list_contact_sync_upsell_title);
                    if (textView2 != null) {
                        WidgetFriendsListContactSyncUpsellBinding widgetFriendsListContactSyncUpsellBinding = new WidgetFriendsListContactSyncUpsellBinding(materialCardView, imageView, materialCardView, imageView2, textView, textView2);
                        m.checkNotNullExpressionValue(widgetFriendsListContactSyncUpsellBinding, "WidgetFriendsListContact…ellBinding.bind(itemView)");
                        this.binding = widgetFriendsListContactSyncUpsellBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetFriendsListAdapter access$getAdapter$p(WidgetFriendsListAdapter$ItemContactSyncUpsell widgetFriendsListAdapter$ItemContactSyncUpsell) {
        return (WidgetFriendsListAdapter) widgetFriendsListAdapter$ItemContactSyncUpsell.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, FriendsListViewModel$Item friendsListViewModel$Item) {
        onConfigure2(i, friendsListViewModel$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, FriendsListViewModel$Item data) {
        m.checkNotNullParameter(data, "data");
        this.binding.f2397b.setOnClickListener(new WidgetFriendsListAdapter$ItemContactSyncUpsell$onConfigure$1(this));
        this.binding.f2397b.setOnLongClickListener(new WidgetFriendsListAdapter$ItemContactSyncUpsell$onConfigure$2(this));
    }
}
