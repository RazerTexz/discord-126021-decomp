package com.discord.utilities.directories;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import b.a.a.e;
import b.a.a.e$c;
import b.a.d.j;
import b.a.k.b;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.app.AppFragment;
import com.discord.dialogs.SimpleConfirmationDialogArgs;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.hubs.HubDescriptionArgs;
import com.discord.widgets.hubs.WidgetHubDescription;
import com.discord.widgets.mobile_reports.WidgetMobileReports;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DirectoryUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DirectoryUtils$showServerOptions$2 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ DirectoryEntryGuild $directoryEntry;
    public final /* synthetic */ AppFragment $fragment;
    public final /* synthetic */ String $hubName;
    public final /* synthetic */ List $options;
    public final /* synthetic */ Function0 $removeGuildListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectoryUtils$showServerOptions$2(List list, Context context, DirectoryEntryGuild directoryEntryGuild, String str, AppFragment appFragment, Function0 function0) {
        super(1);
        this.$options = list;
        this.$context = context;
        this.$directoryEntry = directoryEntryGuild;
        this.$hubName = str;
        this.$fragment = appFragment;
        this.$removeGuildListener = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        DirectoryUtils$DirectoryServerMenuOptions directoryUtils$DirectoryServerMenuOptions = (DirectoryUtils$DirectoryServerMenuOptions) u.getOrNull(this.$options, i);
        if (directoryUtils$DirectoryServerMenuOptions != null) {
            int iOrdinal = directoryUtils$DirectoryServerMenuOptions.ordinal();
            if (iOrdinal == 0) {
                j.d(this.$context, WidgetHubDescription.class, new HubDescriptionArgs(this.$directoryEntry.getGuild().getId(), this.$directoryEntry.getDirectoryChannelId(), true, this.$hubName, false, this.$directoryEntry.getDescription(), Integer.valueOf(this.$directoryEntry.getPrimaryCategoryId()), 16, null));
                return;
            }
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    return;
                }
                WidgetMobileReports.Companion.launchDirectoryServerReport(this.$context, this.$directoryEntry.getGuild().getId(), this.$directoryEntry.getEntityId(), this.$directoryEntry.getDirectoryChannelId());
            } else {
                e$c e_c = e.k;
                FragmentManager childFragmentManager = this.$fragment.getChildFragmentManager();
                m.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
                e_c.a(childFragmentManager, new SimpleConfirmationDialogArgs(this.$fragment.getString(2131891806), b.h(this.$context, 2131891807, new Object[]{this.$directoryEntry.getGuild().getName()}, null, 4).toString(), this.$fragment.getString(2131894737), this.$fragment.getString(2131887437)), new DirectoryUtils$showServerOptions$2$1(this));
            }
        }
    }
}
