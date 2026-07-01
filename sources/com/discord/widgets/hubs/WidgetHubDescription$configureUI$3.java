package com.discord.widgets.hubs;

import androidx.fragment.app.FragmentActivity;
import b.c.a.a0.d;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.Success;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription$configureUI$3 extends o implements Function1<Success<? extends DirectoryEntryGuild>, Unit> {
    public final /* synthetic */ WidgetHubDescription this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription$configureUI$3(WidgetHubDescription widgetHubDescription) {
        super(1);
        this.this$0 = widgetHubDescription;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Success<? extends DirectoryEntryGuild> success) {
        invoke2((Success<DirectoryEntryGuild>) success);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Success<DirectoryEntryGuild> success) {
        m.checkNotNullParameter(success, "it");
        StoreStream.Companion.getDirectories().addServerToDirectory(this.this$0.getArgs().getChannelId(), success.invoke());
        WidgetHubDescription widgetHubDescription = this.this$0;
        widgetHubDescription.hideKeyboard(widgetHubDescription.getView());
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.setResult(-1, d.g2(new DescriptionResult(success.invoke().getGuild().getId(), this.this$0.getArgs().getHubName())));
            activity.finish();
        }
    }
}
