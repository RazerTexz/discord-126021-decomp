package com.discord.widgets.guilds;

import android.content.Context;
import b.a.d.d0;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.restapi.RestAPIParams$UserSettings;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreGuildsSorted$Entry;
import com.discord.stores.StoreGuildsSorted$Entry$Folder;
import com.discord.stores.StoreGuildsSorted$Entry$SingletonGuild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildFolderSettingsViewModel extends d0<WidgetGuildFolderSettingsViewModel$ViewState> {
    public static final WidgetGuildFolderSettingsViewModel$Companion Companion = new WidgetGuildFolderSettingsViewModel$Companion(null);
    private final PublishSubject<WidgetGuildFolderSettingsViewModel$Event> eventSubject;
    private final long folderId;
    private WidgetGuildFolderSettingsViewModel$StoreState previousStoreState;
    private final StoreUserSettings storeUserSettings;

    public /* synthetic */ WidgetGuildFolderSettingsViewModel(long j, StoreUserSettings storeUserSettings, StoreGuildsSorted storeGuildsSorted, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? StoreStream.Companion.getUserSettings() : storeUserSettings, (i & 4) != 0 ? StoreStream.Companion.getGuildsSorted() : storeGuildsSorted);
    }

    public static final /* synthetic */ void access$emitUpdateFailureEvent(WidgetGuildFolderSettingsViewModel widgetGuildFolderSettingsViewModel) {
        widgetGuildFolderSettingsViewModel.emitUpdateFailureEvent();
    }

    public static final /* synthetic */ void access$emitUpdateSuccessEvent(WidgetGuildFolderSettingsViewModel widgetGuildFolderSettingsViewModel) {
        widgetGuildFolderSettingsViewModel.emitUpdateSuccessEvent();
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGuildFolderSettingsViewModel widgetGuildFolderSettingsViewModel, WidgetGuildFolderSettingsViewModel$StoreState widgetGuildFolderSettingsViewModel$StoreState) {
        widgetGuildFolderSettingsViewModel.handleStoreState(widgetGuildFolderSettingsViewModel$StoreState);
    }

    private final void emitUpdateFailureEvent() {
        PublishSubject<WidgetGuildFolderSettingsViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsFailure(2131888366));
    }

    private final void emitUpdateSuccessEvent() {
        PublishSubject<WidgetGuildFolderSettingsViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsSuccess(2131890231));
    }

    private final void handleStoreState(WidgetGuildFolderSettingsViewModel$StoreState storeState) {
        this.previousStoreState = storeState;
        if (storeState instanceof WidgetGuildFolderSettingsViewModel$StoreState$Valid) {
            WidgetGuildFolderSettingsViewModel$StoreState$Valid widgetGuildFolderSettingsViewModel$StoreState$Valid = (WidgetGuildFolderSettingsViewModel$StoreState$Valid) storeState;
            WidgetGuildFolderSettingsViewModel$FormState widgetGuildFolderSettingsViewModel$FormState = new WidgetGuildFolderSettingsViewModel$FormState(widgetGuildFolderSettingsViewModel$StoreState$Valid.getFolder().getName(), widgetGuildFolderSettingsViewModel$StoreState$Valid.getFolder().getColor());
            updateViewState(new WidgetGuildFolderSettingsViewModel$ViewState$Loaded(widgetGuildFolderSettingsViewModel$FormState, shouldShowSave(widgetGuildFolderSettingsViewModel$StoreState$Valid, widgetGuildFolderSettingsViewModel$FormState)));
        }
    }

    private final boolean shouldShowSave(WidgetGuildFolderSettingsViewModel$StoreState$Valid storeState, WidgetGuildFolderSettingsViewModel$FormState formState) {
        return (m.areEqual(storeState.getFolder().getColor(), formState.getColor()) ^ true) || (m.areEqual(storeState.getFolder().getName(), formState.getName()) ^ true);
    }

    private final void updateFormState(WidgetGuildFolderSettingsViewModel$FormState formState) {
        WidgetGuildFolderSettingsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetGuildFolderSettingsViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetGuildFolderSettingsViewModel$ViewState$Loaded widgetGuildFolderSettingsViewModel$ViewState$Loaded = (WidgetGuildFolderSettingsViewModel$ViewState$Loaded) viewState;
        if (widgetGuildFolderSettingsViewModel$ViewState$Loaded != null) {
            WidgetGuildFolderSettingsViewModel$StoreState widgetGuildFolderSettingsViewModel$StoreState = this.previousStoreState;
            updateViewState(widgetGuildFolderSettingsViewModel$ViewState$Loaded.copy(formState, widgetGuildFolderSettingsViewModel$StoreState instanceof WidgetGuildFolderSettingsViewModel$StoreState$Valid ? shouldShowSave((WidgetGuildFolderSettingsViewModel$StoreState$Valid) widgetGuildFolderSettingsViewModel$StoreState, formState) : false));
        }
    }

    public final long getFolderId() {
        return this.folderId;
    }

    public final WidgetGuildFolderSettingsViewModel$StoreState getPreviousStoreState() {
        return this.previousStoreState;
    }

    public final StoreUserSettings getStoreUserSettings() {
        return this.storeUserSettings;
    }

    public final Observable<WidgetGuildFolderSettingsViewModel$Event> observeEvents() {
        PublishSubject<WidgetGuildFolderSettingsViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void saveFolder() {
        ModelGuildFolder modelGuildFolderAsModelGuildFolder;
        WidgetGuildFolderSettingsViewModel$StoreState widgetGuildFolderSettingsViewModel$StoreState = this.previousStoreState;
        if (!(widgetGuildFolderSettingsViewModel$StoreState instanceof WidgetGuildFolderSettingsViewModel$StoreState$Valid)) {
            widgetGuildFolderSettingsViewModel$StoreState = null;
        }
        WidgetGuildFolderSettingsViewModel$StoreState$Valid widgetGuildFolderSettingsViewModel$StoreState$Valid = (WidgetGuildFolderSettingsViewModel$StoreState$Valid) widgetGuildFolderSettingsViewModel$StoreState;
        if (widgetGuildFolderSettingsViewModel$StoreState$Valid != null) {
            WidgetGuildFolderSettingsViewModel$ViewState viewState = getViewState();
            if (!(viewState instanceof WidgetGuildFolderSettingsViewModel$ViewState$Loaded)) {
                viewState = null;
            }
            WidgetGuildFolderSettingsViewModel$ViewState$Loaded widgetGuildFolderSettingsViewModel$ViewState$Loaded = (WidgetGuildFolderSettingsViewModel$ViewState$Loaded) viewState;
            if (widgetGuildFolderSettingsViewModel$ViewState$Loaded != null) {
                WidgetGuildFolderSettingsViewModel$FormState formState = widgetGuildFolderSettingsViewModel$ViewState$Loaded.getFormState();
                List<StoreGuildsSorted$Entry> sortedGuilds = widgetGuildFolderSettingsViewModel$StoreState$Valid.getSortedGuilds();
                ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(sortedGuilds, 10));
                for (StoreGuildsSorted$Entry storeGuildsSorted$Entry : sortedGuilds) {
                    if (storeGuildsSorted$Entry instanceof StoreGuildsSorted$Entry$SingletonGuild) {
                        modelGuildFolderAsModelGuildFolder = storeGuildsSorted$Entry.asModelGuildFolder();
                    } else {
                        if (!(storeGuildsSorted$Entry instanceof StoreGuildsSorted$Entry$Folder)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        StoreGuildsSorted$Entry$Folder storeGuildsSorted$Entry$Folder = (StoreGuildsSorted$Entry$Folder) storeGuildsSorted$Entry;
                        modelGuildFolderAsModelGuildFolder = storeGuildsSorted$Entry$Folder.getId() == this.folderId ? StoreGuildsSorted$Entry$Folder.copy$default(storeGuildsSorted$Entry$Folder, 0L, null, formState.getColor(), formState.getName(), 3, null).asModelGuildFolder() : storeGuildsSorted$Entry.asModelGuildFolder();
                    }
                    arrayList.add(modelGuildFolderAsModelGuildFolder);
                }
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().updateUserSettings(RestAPIParams$UserSettings.Companion.createWithGuildFolders(arrayList)), false, 1, null), this, null, 2, null), WidgetGuildFolderSettingsViewModel.class, (Context) null, (Function1) null, new WidgetGuildFolderSettingsViewModel$saveFolder$2(this), (Function0) null, (Function0) null, new WidgetGuildFolderSettingsViewModel$saveFolder$1(this), 54, (Object) null);
            }
        }
    }

    public final void setColor(Integer color) {
        WidgetGuildFolderSettingsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetGuildFolderSettingsViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetGuildFolderSettingsViewModel$ViewState$Loaded widgetGuildFolderSettingsViewModel$ViewState$Loaded = (WidgetGuildFolderSettingsViewModel$ViewState$Loaded) viewState;
        if (widgetGuildFolderSettingsViewModel$ViewState$Loaded != null) {
            updateFormState(WidgetGuildFolderSettingsViewModel$FormState.copy$default(widgetGuildFolderSettingsViewModel$ViewState$Loaded.getFormState(), null, color, 1, null));
        }
    }

    public final void setName(String name) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        WidgetGuildFolderSettingsViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetGuildFolderSettingsViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetGuildFolderSettingsViewModel$ViewState$Loaded widgetGuildFolderSettingsViewModel$ViewState$Loaded = (WidgetGuildFolderSettingsViewModel$ViewState$Loaded) viewState;
        if (widgetGuildFolderSettingsViewModel$ViewState$Loaded != null) {
            updateFormState(WidgetGuildFolderSettingsViewModel$FormState.copy$default(widgetGuildFolderSettingsViewModel$ViewState$Loaded.getFormState(), name, null, 2, null));
        }
    }

    public final void setPreviousStoreState(WidgetGuildFolderSettingsViewModel$StoreState widgetGuildFolderSettingsViewModel$StoreState) {
        this.previousStoreState = widgetGuildFolderSettingsViewModel$StoreState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildFolderSettingsViewModel(long j, StoreUserSettings storeUserSettings, StoreGuildsSorted storeGuildsSorted) {
        super(WidgetGuildFolderSettingsViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        m.checkNotNullParameter(storeGuildsSorted, "storeGuildsSorted");
        this.folderId = j;
        this.storeUserSettings = storeUserSettings;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(WidgetGuildFolderSettingsViewModel$Companion.access$observeStoreState(Companion, j, storeUserSettings, storeGuildsSorted)), this, null, 2, null), WidgetGuildFolderSettingsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildFolderSettingsViewModel$1(this), 62, (Object) null);
        this.eventSubject = PublishSubject.k0();
    }
}
