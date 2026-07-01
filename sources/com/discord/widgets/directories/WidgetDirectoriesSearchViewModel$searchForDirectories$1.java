package com.discord.widgets.directories;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.stores.utilities.RestCallState;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetDirectoriesSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesSearchViewModel$searchForDirectories$1 extends o implements Function1<RestCallState<? extends List<? extends DirectoryEntryGuild>>, Unit> {
    public final /* synthetic */ CharSequence $query;
    public final /* synthetic */ WidgetDirectoriesSearchViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetDirectoriesSearchViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesSearchViewModel$searchForDirectories$1(WidgetDirectoriesSearchViewModel widgetDirectoriesSearchViewModel, WidgetDirectoriesSearchViewModel$ViewState widgetDirectoriesSearchViewModel$ViewState, CharSequence charSequence) {
        super(1);
        this.this$0 = widgetDirectoriesSearchViewModel;
        this.$viewState = widgetDirectoriesSearchViewModel$ViewState;
        this.$query = charSequence;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends List<? extends DirectoryEntryGuild>> restCallState) {
        invoke2((RestCallState<? extends List<DirectoryEntryGuild>>) restCallState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RestCallState<? extends List<DirectoryEntryGuild>> restCallState) {
        m.checkNotNullParameter(restCallState, "entriesState");
        WidgetDirectoriesSearchViewModel widgetDirectoriesSearchViewModel = this.this$0;
        WidgetDirectoriesSearchViewModel$ViewState widgetDirectoriesSearchViewModel$ViewState = this.$viewState;
        String string = this.$query.toString();
        List<DirectoryEntryGuild> listInvoke = restCallState.invoke();
        if (listInvoke == null) {
            listInvoke = this.$viewState.getDirectories();
        }
        WidgetDirectoriesSearchViewModel.access$updateViewState(widgetDirectoriesSearchViewModel, WidgetDirectoriesSearchViewModel$ViewState.copy$default(widgetDirectoriesSearchViewModel$ViewState, null, string, listInvoke, null, null, false, restCallState, 57, null));
    }
}
