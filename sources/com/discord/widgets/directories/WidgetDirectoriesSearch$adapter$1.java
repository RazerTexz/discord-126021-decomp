package com.discord.widgets.directories;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.stores.StoreStream;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.widgets.directories.DirectoryChannelItemClickInterface;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetDirectoriesSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesSearch$adapter$1 implements DirectoryChannelItemClickInterface {
    public final /* synthetic */ WidgetDirectoriesSearch this$0;

    public WidgetDirectoriesSearch$adapter$1(WidgetDirectoriesSearch widgetDirectoriesSearch) {
        this.this$0 = widgetDirectoriesSearch;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onAddServerClicked() {
        DirectoryChannelItemClickInterface.DefaultImpls.onAddServerClicked(this);
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onEntryClicked(long guildId, long channelId) {
        Context context = this.this$0.getContext();
        if (context != null) {
            WidgetDirectoriesSearchViewModel viewModel = this.this$0.getViewModel();
            C12238m.checkNotNullExpressionValue(context, "it");
            viewModel.joinGuild(context, guildId, channelId);
        }
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onGoToGuildClicked(long guildId) {
        StoreStream.INSTANCE.getGuildSelected().set(guildId);
        FragmentActivity fragmentActivityM95e = this.this$0.m95e();
        if (fragmentActivityM95e != null) {
            fragmentActivityM95e.onBackPressed();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onOverflowClicked(DirectoryEntryGuild directoryEntry, long channelId, boolean isServerOwner) {
        C12238m.checkNotNullParameter(directoryEntry, "directoryEntry");
        DirectoryUtils directoryUtils = DirectoryUtils.INSTANCE;
        WidgetDirectoriesSearch widgetDirectoriesSearch = this.this$0;
        directoryUtils.showServerOptions(widgetDirectoriesSearch, directoryEntry, widgetDirectoriesSearch.getViewModel().getHubName(), isServerOwner, new WidgetDirectoriesSearch$adapter$1$onOverflowClicked$1(this, directoryEntry, channelId));
    }
}
