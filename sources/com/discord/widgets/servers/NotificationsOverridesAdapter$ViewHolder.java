package com.discord.widgets.servers;

import android.view.View;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.models.domain.ModelNotificationSettings;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NotificationsOverridesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class NotificationsOverridesAdapter$ViewHolder extends RecyclerView$ViewHolder {
    private final Function2<View, NotificationsOverridesAdapter$Item, Unit> onClick;

    public /* synthetic */ NotificationsOverridesAdapter$ViewHolder(View view, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, function2);
    }

    public final Function2<View, NotificationsOverridesAdapter$Item, Unit> getOnClick() {
        return this.onClick;
    }

    @StringRes
    public final int messageNotificationToString(int messageNotificationLevel) {
        if (messageNotificationLevel == ModelNotificationSettings.FREQUENCY_ALL) {
            return 2131889130;
        }
        if (messageNotificationLevel == ModelNotificationSettings.FREQUENCY_MENTIONS) {
            return 2131889232;
        }
        return messageNotificationLevel == ModelNotificationSettings.FREQUENCY_NOTHING ? 2131889227 : 0;
    }

    public void onBind(NotificationsOverridesAdapter$Item data) {
        m.checkNotNullParameter(data, "data");
        this.itemView.setOnClickListener(new NotificationsOverridesAdapter$ViewHolder$onBind$1(this, data));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private NotificationsOverridesAdapter$ViewHolder(View view, Function2<? super View, ? super NotificationsOverridesAdapter$Item, Unit> function2) {
        super(view);
        this.onClick = function2;
    }
}
