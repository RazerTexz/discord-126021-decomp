package com.discord.utilities.views;

import android.view.View;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: StickyHeaderItemDecoration.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface StickyHeaderItemDecoration$StickyHeaderAdapter {
    View getAndBindHeaderView(int position);

    Integer getHeaderPositionForItem(int itemPosition);

    boolean isHeader(int position);
}
