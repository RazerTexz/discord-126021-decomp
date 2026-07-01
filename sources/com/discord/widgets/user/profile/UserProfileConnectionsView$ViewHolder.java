package com.discord.widgets.user.profile;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.m;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: UserProfileConnectionsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileConnectionsView$ViewHolder extends MGRecyclerViewHolder<UserProfileConnectionsView$ConnectedAccountsAdapter, UserProfileConnectionsView$ConnectedAccountItem> {
    private final TextView listItemTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileConnectionsView$ViewHolder(@LayoutRes int i, UserProfileConnectionsView$ConnectedAccountsAdapter userProfileConnectionsView$ConnectedAccountsAdapter) {
        super(i, userProfileConnectionsView$ConnectedAccountsAdapter);
        m.checkNotNullParameter(userProfileConnectionsView$ConnectedAccountsAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
        this.listItemTextView = (TextView) view;
    }

    public static final /* synthetic */ UserProfileConnectionsView$ConnectedAccountsAdapter access$getAdapter$p(UserProfileConnectionsView$ViewHolder userProfileConnectionsView$ViewHolder) {
        return (UserProfileConnectionsView$ConnectedAccountsAdapter) userProfileConnectionsView$ViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, UserProfileConnectionsView$ConnectedAccountItem userProfileConnectionsView$ConnectedAccountItem) {
        onConfigure2(i, userProfileConnectionsView$ConnectedAccountItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, UserProfileConnectionsView$ConnectedAccountItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ConnectedAccount connectedAccount = data.getConnectedAccount();
        String name = connectedAccount.getName();
        Platform platformFrom = Platform.Companion.from(connectedAccount);
        Integer themedPlatformImage = platformFrom.getThemedPlatformImage();
        int iIntValue = themedPlatformImage != null ? themedPlatformImage.intValue() : 0;
        String profileUrl = platformFrom.getProfileUrl(connectedAccount);
        TextView textView = this.listItemTextView;
        Integer themedPlatformImage2 = platformFrom.getThemedPlatformImage();
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView, DrawableCompat.getThemedDrawableRes$default(textView, themedPlatformImage2 != null ? themedPlatformImage2.intValue() : 0, 0, 2, (Object) null), 0, 0, 0, 14, null);
        this.listItemTextView.setText(connectedAccount.getName());
        TextView textView2 = this.listItemTextView;
        String str = String.format("%s, %s", Arrays.copyOf(new Object[]{connectedAccount.getType(), connectedAccount.getName()}, 2));
        m.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        textView2.setContentDescription(str);
        this.itemView.setOnClickListener(new UserProfileConnectionsView$ViewHolder$onConfigure$1(this, platformFrom, name, iIntValue, profileUrl));
    }
}
