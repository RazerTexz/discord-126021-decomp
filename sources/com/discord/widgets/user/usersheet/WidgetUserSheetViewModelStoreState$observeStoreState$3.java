package com.discord.widgets.user.usersheet;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.api.user.UserProfile;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreMediaSettings$VoiceConfiguration;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreUserNotes;
import com.discord.stores.StoreUserNotes$UserNoteState;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserProfile;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.widgets.guildcommunicationdisabled.start.GuildCommunicationDisabledGuildsFeatureFlag;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.user.presence.ModelRichPresence;
import d0.t.h0;
import d0.t.n;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: WidgetUserSheetViewModelStoreState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheetViewModelStoreState$observeStoreState$3<T, R> implements b<WidgetUserSheetViewModelStoreState$BootstrapData, Observable<? extends WidgetUserSheetViewModel$StoreState>> {
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreMediaSettings $storeMediaSettings;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreStageChannels $storeStageChannels;
    public final /* synthetic */ StoreUserNotes $storeUserNotes;
    public final /* synthetic */ StoreUserPresence $storeUserPresence;
    public final /* synthetic */ StoreUserProfile $storeUserProfile;
    public final /* synthetic */ StoreUserRelationships $storeUserRelationships;
    public final /* synthetic */ StoreVoiceStates $storeVoiceStates;
    public final /* synthetic */ StreamContextService $streamContextService;

    public WidgetUserSheetViewModelStoreState$observeStoreState$3(Long l, StoreGuilds storeGuilds, StoreVoiceStates storeVoiceStates, StoreUserPresence storeUserPresence, StorePermissions storePermissions, StreamContextService streamContextService, StoreStageChannels storeStageChannels, StoreMediaSettings storeMediaSettings, StoreUserProfile storeUserProfile, StoreUserRelationships storeUserRelationships, StoreUserNotes storeUserNotes) {
        this.$guildId = l;
        this.$storeGuilds = storeGuilds;
        this.$storeVoiceStates = storeVoiceStates;
        this.$storeUserPresence = storeUserPresence;
        this.$storePermissions = storePermissions;
        this.$streamContextService = streamContextService;
        this.$storeStageChannels = storeStageChannels;
        this.$storeMediaSettings = storeMediaSettings;
        this.$storeUserProfile = storeUserProfile;
        this.$storeUserRelationships = storeUserRelationships;
        this.$storeUserNotes = storeUserNotes;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetUserSheetViewModel$StoreState> call(WidgetUserSheetViewModelStoreState$BootstrapData widgetUserSheetViewModelStoreState$BootstrapData) {
        return call2(widgetUserSheetViewModelStoreState$BootstrapData);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0065  */
    /* JADX WARN: Code duplicated, block: B:21:0x0082  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:46:0x0112  */
    /* JADX WARN: Code duplicated, block: B:49:0x0126  */
    /* JADX WARN: Code duplicated, block: B:52:0x0131  */
    /* JADX WARN: Code duplicated, block: B:55:0x0144  */
    /* JADX WARN: Code duplicated, block: B:58:0x0150  */
    /* JADX WARN: Code duplicated, block: B:61:0x015d  */
    /* JADX WARN: Code duplicated, block: B:63:0x0165  */
    /* JADX WARN: Code duplicated, block: B:66:0x0179  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetUserSheetViewModel$StoreState> call2(WidgetUserSheetViewModelStoreState$BootstrapData widgetUserSheetViewModelStoreState$BootstrapData) {
        Observable<Map<Long, GuildMember>> kVar;
        Observable<Map<Long, GuildRole>> kVar2;
        Observable<Guild> kVar3;
        Observable<Map<Long, GuildMember>> observable;
        Observable<Long> kVar4;
        MeUser meUser;
        Channel channel;
        Observable<StageRoles> kVar5;
        MeUser meUser2;
        Observable<StageRequestToSpeakState> kVar6;
        Observable<StageRoles> kVar7;
        Observable<Boolean> kVar8;
        Observable<Map<Long, VoiceState>> observableObserve;
        Observable<Map<Long, VoiceState>> observableObserve2;
        User user = widgetUserSheetViewModelStoreState$BootstrapData.getUser();
        MeUser me2 = widgetUserSheetViewModelStoreState$BootstrapData.getMe();
        Channel channel2 = widgetUserSheetViewModelStoreState$BootstrapData.getChannel();
        Channel selectedVoiceChannel = widgetUserSheetViewModelStoreState$BootstrapData.getSelectedVoiceChannel();
        if (user == null) {
            return Observable.d0(5L, TimeUnit.SECONDS).G(WidgetUserSheetViewModelStoreState$observeStoreState$3$1.INSTANCE);
        }
        Long lValueOf = this.$guildId;
        if (lValueOf == null) {
            lValueOf = channel2 != null ? Long.valueOf(channel2.getGuildId()) : null;
        }
        if (lValueOf != null) {
            lValueOf.longValue();
            Observable<Map<Long, GuildMember>> observableObserveComputed = this.$storeGuilds.observeComputed(lValueOf.longValue(), n.listOf((Object[]) new Long[]{Long.valueOf(user.getId()), Long.valueOf(me2.getId())}));
            if (observableObserveComputed != null) {
                kVar = observableObserveComputed;
            } else {
                kVar = new k(h0.emptyMap());
            }
        } else {
            kVar = new k(h0.emptyMap());
        }
        if (lValueOf != null) {
            lValueOf.longValue();
            Observable<Map<Long, GuildRole>> observableObserveRoles = this.$storeGuilds.observeRoles(lValueOf.longValue());
            if (observableObserveRoles != null) {
                kVar2 = observableObserveRoles;
            } else {
                kVar2 = new k(h0.emptyMap());
            }
        } else {
            kVar2 = new k(h0.emptyMap());
        }
        Observable<Map<Long, VoiceState>> kVar9 = (selectedVoiceChannel == null || (observableObserve2 = this.$storeVoiceStates.observe(selectedVoiceChannel.getGuildId(), selectedVoiceChannel.getId())) == null) ? new k(h0.emptyMap()) : observableObserve2;
        Observable<Map<Long, VoiceState>> kVar10 = (channel2 == null || (observableObserve = this.$storeVoiceStates.observe(channel2.getGuildId(), channel2.getId())) == null) ? new k(h0.emptyMap()) : observableObserve;
        Observable<ModelRichPresence> observable2 = ModelRichPresence.Companion.get(user.getId(), this.$storeUserPresence);
        if (lValueOf != null) {
            lValueOf.longValue();
            kVar3 = this.$storeGuilds.observeGuild(lValueOf.longValue());
            if (kVar3 == null) {
                kVar3 = new k<>(null);
            }
        } else {
            kVar3 = new k<>(null);
        }
        if (channel2 != null) {
            observable = kVar;
            kVar4 = this.$storePermissions.observePermissionsForChannel(channel2.getId());
            if (kVar4 == null) {
            }
            Observable<StreamContext> forUser = this.$streamContextService.getForUser(user.getId(), true);
            if (selectedVoiceChannel != null) {
                meUser = me2;
                channel = channel2;
                kVar5 = this.$storeStageChannels.observeUserRoles(user.getId(), selectedVoiceChannel.getId());
                if (kVar5 == null) {
                }
                if (selectedVoiceChannel != null) {
                    meUser2 = meUser;
                    kVar6 = this.$storeStageChannels.observeUserRequestToSpeakState(user.getId(), selectedVoiceChannel.getId());
                    if (kVar6 == null) {
                    }
                    if (selectedVoiceChannel != null || (kVar7 = this.$storeStageChannels.observeMyRoles(selectedVoiceChannel.getId())) == null) {
                        kVar7 = new k<>(null);
                    }
                    if (lValueOf != null) {
                        lValueOf.longValue();
                        kVar8 = GuildCommunicationDisabledGuildsFeatureFlag.Companion.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                        if (kVar8 == null) {
                            kVar8 = new k(Boolean.FALSE);
                        }
                    } else {
                        kVar8 = new k(Boolean.FALSE);
                    }
                    m.checkNotNullExpressionValue(observable, "computedMembersObservable");
                    m.checkNotNullExpressionValue(kVar2, "guildRolesObservable");
                    m.checkNotNullExpressionValue(kVar9, "mySelectedVoiceChannelVoiceStatesObservable");
                    m.checkNotNullExpressionValue(kVar10, "currentChannelVoiceStatesObservable");
                    Observable<StoreMediaSettings$VoiceConfiguration> voiceConfig = this.$storeMediaSettings.getVoiceConfig();
                    m.checkNotNullExpressionValue(kVar3, "guildsObservable");
                    m.checkNotNullExpressionValue(kVar4, "permissionsObservable");
                    Observable<UserProfile> observableObserveUserProfile = this.$storeUserProfile.observeUserProfile(user.getId());
                    Observable<Integer> observableObserve3 = this.$storeUserRelationships.observe(user.getId());
                    Observable<StoreUserNotes$UserNoteState> observableObserveUserNote = this.$storeUserNotes.observeUserNote(user.getId());
                    m.checkNotNullExpressionValue(kVar5, "userStageRolesObservable");
                    m.checkNotNullExpressionValue(kVar6, "userStageRequestToSpeakStateObservable");
                    m.checkNotNullExpressionValue(kVar7, "myStageRolesObservable");
                    m.checkNotNullExpressionValue(kVar8, "canDisableCommunicationObservable");
                    return ObservableCombineLatestOverloadsKt.combineLatest(observable, kVar2, kVar9, kVar10, voiceConfig, observable2, kVar3, kVar4, forUser, observableObserveUserProfile, observableObserve3, observableObserveUserNote, kVar5, kVar6, kVar7, kVar8, new WidgetUserSheetViewModelStoreState$observeStoreState$3$2(user, meUser2, channel, selectedVoiceChannel));
                }
                meUser2 = meUser;
                kVar6 = new k(StageRequestToSpeakState.NONE);
                if (selectedVoiceChannel != null) {
                    kVar7 = new k<>(null);
                } else {
                    kVar7 = new k<>(null);
                }
                if (lValueOf != null) {
                    lValueOf.longValue();
                    kVar8 = GuildCommunicationDisabledGuildsFeatureFlag.Companion.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                    if (kVar8 == null) {
                        kVar8 = new k(Boolean.FALSE);
                    }
                } else {
                    kVar8 = new k(Boolean.FALSE);
                }
                m.checkNotNullExpressionValue(observable, "computedMembersObservable");
                m.checkNotNullExpressionValue(kVar2, "guildRolesObservable");
                m.checkNotNullExpressionValue(kVar9, "mySelectedVoiceChannelVoiceStatesObservable");
                m.checkNotNullExpressionValue(kVar10, "currentChannelVoiceStatesObservable");
                Observable<StoreMediaSettings$VoiceConfiguration> voiceConfig2 = this.$storeMediaSettings.getVoiceConfig();
                m.checkNotNullExpressionValue(kVar3, "guildsObservable");
                m.checkNotNullExpressionValue(kVar4, "permissionsObservable");
                Observable<UserProfile> observableObserveUserProfile2 = this.$storeUserProfile.observeUserProfile(user.getId());
                Observable<Integer> observableObserve4 = this.$storeUserRelationships.observe(user.getId());
                Observable<StoreUserNotes$UserNoteState> observableObserveUserNote2 = this.$storeUserNotes.observeUserNote(user.getId());
                m.checkNotNullExpressionValue(kVar5, "userStageRolesObservable");
                m.checkNotNullExpressionValue(kVar6, "userStageRequestToSpeakStateObservable");
                m.checkNotNullExpressionValue(kVar7, "myStageRolesObservable");
                m.checkNotNullExpressionValue(kVar8, "canDisableCommunicationObservable");
                return ObservableCombineLatestOverloadsKt.combineLatest(observable, kVar2, kVar9, kVar10, voiceConfig2, observable2, kVar3, kVar4, forUser, observableObserveUserProfile2, observableObserve4, observableObserveUserNote2, kVar5, kVar6, kVar7, kVar8, new WidgetUserSheetViewModelStoreState$observeStoreState$3$2(user, meUser2, channel, selectedVoiceChannel));
            }
            meUser = me2;
            channel = channel2;
            kVar5 = new k<>(null);
            if (selectedVoiceChannel != null) {
                meUser2 = meUser;
                kVar6 = this.$storeStageChannels.observeUserRequestToSpeakState(user.getId(), selectedVoiceChannel.getId());
                if (kVar6 == null) {
                }
                if (selectedVoiceChannel != null) {
                    kVar7 = new k<>(null);
                } else {
                    kVar7 = new k<>(null);
                }
                if (lValueOf != null) {
                    lValueOf.longValue();
                    kVar8 = GuildCommunicationDisabledGuildsFeatureFlag.Companion.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                    if (kVar8 == null) {
                        kVar8 = new k(Boolean.FALSE);
                    }
                } else {
                    kVar8 = new k(Boolean.FALSE);
                }
                m.checkNotNullExpressionValue(observable, "computedMembersObservable");
                m.checkNotNullExpressionValue(kVar2, "guildRolesObservable");
                m.checkNotNullExpressionValue(kVar9, "mySelectedVoiceChannelVoiceStatesObservable");
                m.checkNotNullExpressionValue(kVar10, "currentChannelVoiceStatesObservable");
                Observable<StoreMediaSettings$VoiceConfiguration> voiceConfig3 = this.$storeMediaSettings.getVoiceConfig();
                m.checkNotNullExpressionValue(kVar3, "guildsObservable");
                m.checkNotNullExpressionValue(kVar4, "permissionsObservable");
                Observable<UserProfile> observableObserveUserProfile3 = this.$storeUserProfile.observeUserProfile(user.getId());
                Observable<Integer> observableObserve5 = this.$storeUserRelationships.observe(user.getId());
                Observable<StoreUserNotes$UserNoteState> observableObserveUserNote3 = this.$storeUserNotes.observeUserNote(user.getId());
                m.checkNotNullExpressionValue(kVar5, "userStageRolesObservable");
                m.checkNotNullExpressionValue(kVar6, "userStageRequestToSpeakStateObservable");
                m.checkNotNullExpressionValue(kVar7, "myStageRolesObservable");
                m.checkNotNullExpressionValue(kVar8, "canDisableCommunicationObservable");
                return ObservableCombineLatestOverloadsKt.combineLatest(observable, kVar2, kVar9, kVar10, voiceConfig3, observable2, kVar3, kVar4, forUser, observableObserveUserProfile3, observableObserve5, observableObserveUserNote3, kVar5, kVar6, kVar7, kVar8, new WidgetUserSheetViewModelStoreState$observeStoreState$3$2(user, meUser2, channel, selectedVoiceChannel));
            }
            meUser2 = meUser;
            kVar6 = new k(StageRequestToSpeakState.NONE);
            if (selectedVoiceChannel != null) {
                kVar7 = new k<>(null);
            } else {
                kVar7 = new k<>(null);
            }
            if (lValueOf != null) {
                lValueOf.longValue();
                kVar8 = GuildCommunicationDisabledGuildsFeatureFlag.Companion.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                if (kVar8 == null) {
                    kVar8 = new k(Boolean.FALSE);
                }
            } else {
                kVar8 = new k(Boolean.FALSE);
            }
            m.checkNotNullExpressionValue(observable, "computedMembersObservable");
            m.checkNotNullExpressionValue(kVar2, "guildRolesObservable");
            m.checkNotNullExpressionValue(kVar9, "mySelectedVoiceChannelVoiceStatesObservable");
            m.checkNotNullExpressionValue(kVar10, "currentChannelVoiceStatesObservable");
            Observable<StoreMediaSettings$VoiceConfiguration> voiceConfig4 = this.$storeMediaSettings.getVoiceConfig();
            m.checkNotNullExpressionValue(kVar3, "guildsObservable");
            m.checkNotNullExpressionValue(kVar4, "permissionsObservable");
            Observable<UserProfile> observableObserveUserProfile4 = this.$storeUserProfile.observeUserProfile(user.getId());
            Observable<Integer> observableObserve6 = this.$storeUserRelationships.observe(user.getId());
            Observable<StoreUserNotes$UserNoteState> observableObserveUserNote4 = this.$storeUserNotes.observeUserNote(user.getId());
            m.checkNotNullExpressionValue(kVar5, "userStageRolesObservable");
            m.checkNotNullExpressionValue(kVar6, "userStageRequestToSpeakStateObservable");
            m.checkNotNullExpressionValue(kVar7, "myStageRolesObservable");
            m.checkNotNullExpressionValue(kVar8, "canDisableCommunicationObservable");
            return ObservableCombineLatestOverloadsKt.combineLatest(observable, kVar2, kVar9, kVar10, voiceConfig4, observable2, kVar3, kVar4, forUser, observableObserveUserProfile4, observableObserve6, observableObserveUserNote4, kVar5, kVar6, kVar7, kVar8, new WidgetUserSheetViewModelStoreState$observeStoreState$3$2(user, meUser2, channel, selectedVoiceChannel));
        }
        observable = kVar;
        kVar4 = new k<>(null);
        Observable<StreamContext> forUser2 = this.$streamContextService.getForUser(user.getId(), true);
        if (selectedVoiceChannel != null) {
            meUser = me2;
            channel = channel2;
            kVar5 = this.$storeStageChannels.observeUserRoles(user.getId(), selectedVoiceChannel.getId());
            if (kVar5 == null) {
            }
            if (selectedVoiceChannel != null) {
                meUser2 = meUser;
                kVar6 = this.$storeStageChannels.observeUserRequestToSpeakState(user.getId(), selectedVoiceChannel.getId());
                if (kVar6 == null) {
                }
                if (selectedVoiceChannel != null) {
                    kVar7 = new k<>(null);
                } else {
                    kVar7 = new k<>(null);
                }
                if (lValueOf != null) {
                    lValueOf.longValue();
                    kVar8 = GuildCommunicationDisabledGuildsFeatureFlag.Companion.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                    if (kVar8 == null) {
                        kVar8 = new k(Boolean.FALSE);
                    }
                } else {
                    kVar8 = new k(Boolean.FALSE);
                }
                m.checkNotNullExpressionValue(observable, "computedMembersObservable");
                m.checkNotNullExpressionValue(kVar2, "guildRolesObservable");
                m.checkNotNullExpressionValue(kVar9, "mySelectedVoiceChannelVoiceStatesObservable");
                m.checkNotNullExpressionValue(kVar10, "currentChannelVoiceStatesObservable");
                Observable<StoreMediaSettings$VoiceConfiguration> voiceConfig5 = this.$storeMediaSettings.getVoiceConfig();
                m.checkNotNullExpressionValue(kVar3, "guildsObservable");
                m.checkNotNullExpressionValue(kVar4, "permissionsObservable");
                Observable<UserProfile> observableObserveUserProfile5 = this.$storeUserProfile.observeUserProfile(user.getId());
                Observable<Integer> observableObserve7 = this.$storeUserRelationships.observe(user.getId());
                Observable<StoreUserNotes$UserNoteState> observableObserveUserNote5 = this.$storeUserNotes.observeUserNote(user.getId());
                m.checkNotNullExpressionValue(kVar5, "userStageRolesObservable");
                m.checkNotNullExpressionValue(kVar6, "userStageRequestToSpeakStateObservable");
                m.checkNotNullExpressionValue(kVar7, "myStageRolesObservable");
                m.checkNotNullExpressionValue(kVar8, "canDisableCommunicationObservable");
                return ObservableCombineLatestOverloadsKt.combineLatest(observable, kVar2, kVar9, kVar10, voiceConfig5, observable2, kVar3, kVar4, forUser2, observableObserveUserProfile5, observableObserve7, observableObserveUserNote5, kVar5, kVar6, kVar7, kVar8, new WidgetUserSheetViewModelStoreState$observeStoreState$3$2(user, meUser2, channel, selectedVoiceChannel));
            }
            meUser2 = meUser;
            kVar6 = new k(StageRequestToSpeakState.NONE);
            if (selectedVoiceChannel != null) {
                kVar7 = new k<>(null);
            } else {
                kVar7 = new k<>(null);
            }
            if (lValueOf != null) {
                lValueOf.longValue();
                kVar8 = GuildCommunicationDisabledGuildsFeatureFlag.Companion.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                if (kVar8 == null) {
                    kVar8 = new k(Boolean.FALSE);
                }
            } else {
                kVar8 = new k(Boolean.FALSE);
            }
            m.checkNotNullExpressionValue(observable, "computedMembersObservable");
            m.checkNotNullExpressionValue(kVar2, "guildRolesObservable");
            m.checkNotNullExpressionValue(kVar9, "mySelectedVoiceChannelVoiceStatesObservable");
            m.checkNotNullExpressionValue(kVar10, "currentChannelVoiceStatesObservable");
            Observable<StoreMediaSettings$VoiceConfiguration> voiceConfig6 = this.$storeMediaSettings.getVoiceConfig();
            m.checkNotNullExpressionValue(kVar3, "guildsObservable");
            m.checkNotNullExpressionValue(kVar4, "permissionsObservable");
            Observable<UserProfile> observableObserveUserProfile6 = this.$storeUserProfile.observeUserProfile(user.getId());
            Observable<Integer> observableObserve8 = this.$storeUserRelationships.observe(user.getId());
            Observable<StoreUserNotes$UserNoteState> observableObserveUserNote6 = this.$storeUserNotes.observeUserNote(user.getId());
            m.checkNotNullExpressionValue(kVar5, "userStageRolesObservable");
            m.checkNotNullExpressionValue(kVar6, "userStageRequestToSpeakStateObservable");
            m.checkNotNullExpressionValue(kVar7, "myStageRolesObservable");
            m.checkNotNullExpressionValue(kVar8, "canDisableCommunicationObservable");
            return ObservableCombineLatestOverloadsKt.combineLatest(observable, kVar2, kVar9, kVar10, voiceConfig6, observable2, kVar3, kVar4, forUser2, observableObserveUserProfile6, observableObserve8, observableObserveUserNote6, kVar5, kVar6, kVar7, kVar8, new WidgetUserSheetViewModelStoreState$observeStoreState$3$2(user, meUser2, channel, selectedVoiceChannel));
        }
        meUser = me2;
        channel = channel2;
        kVar5 = new k<>(null);
        if (selectedVoiceChannel != null) {
            meUser2 = meUser;
            kVar6 = this.$storeStageChannels.observeUserRequestToSpeakState(user.getId(), selectedVoiceChannel.getId());
            if (kVar6 == null) {
            }
            if (selectedVoiceChannel != null) {
                kVar7 = new k<>(null);
            } else {
                kVar7 = new k<>(null);
            }
            if (lValueOf != null) {
                lValueOf.longValue();
                kVar8 = GuildCommunicationDisabledGuildsFeatureFlag.Companion.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                if (kVar8 == null) {
                    kVar8 = new k(Boolean.FALSE);
                }
            } else {
                kVar8 = new k(Boolean.FALSE);
            }
            m.checkNotNullExpressionValue(observable, "computedMembersObservable");
            m.checkNotNullExpressionValue(kVar2, "guildRolesObservable");
            m.checkNotNullExpressionValue(kVar9, "mySelectedVoiceChannelVoiceStatesObservable");
            m.checkNotNullExpressionValue(kVar10, "currentChannelVoiceStatesObservable");
            Observable<StoreMediaSettings$VoiceConfiguration> voiceConfig7 = this.$storeMediaSettings.getVoiceConfig();
            m.checkNotNullExpressionValue(kVar3, "guildsObservable");
            m.checkNotNullExpressionValue(kVar4, "permissionsObservable");
            Observable<UserProfile> observableObserveUserProfile7 = this.$storeUserProfile.observeUserProfile(user.getId());
            Observable<Integer> observableObserve9 = this.$storeUserRelationships.observe(user.getId());
            Observable<StoreUserNotes$UserNoteState> observableObserveUserNote7 = this.$storeUserNotes.observeUserNote(user.getId());
            m.checkNotNullExpressionValue(kVar5, "userStageRolesObservable");
            m.checkNotNullExpressionValue(kVar6, "userStageRequestToSpeakStateObservable");
            m.checkNotNullExpressionValue(kVar7, "myStageRolesObservable");
            m.checkNotNullExpressionValue(kVar8, "canDisableCommunicationObservable");
            return ObservableCombineLatestOverloadsKt.combineLatest(observable, kVar2, kVar9, kVar10, voiceConfig7, observable2, kVar3, kVar4, forUser2, observableObserveUserProfile7, observableObserve9, observableObserveUserNote7, kVar5, kVar6, kVar7, kVar8, new WidgetUserSheetViewModelStoreState$observeStoreState$3$2(user, meUser2, channel, selectedVoiceChannel));
        }
        meUser2 = meUser;
        kVar6 = new k(StageRequestToSpeakState.NONE);
        if (selectedVoiceChannel != null) {
            kVar7 = new k<>(null);
        } else {
            kVar7 = new k<>(null);
        }
        if (lValueOf != null) {
            lValueOf.longValue();
            kVar8 = GuildCommunicationDisabledGuildsFeatureFlag.Companion.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
            if (kVar8 == null) {
                kVar8 = new k(Boolean.FALSE);
            }
        } else {
            kVar8 = new k(Boolean.FALSE);
        }
        m.checkNotNullExpressionValue(observable, "computedMembersObservable");
        m.checkNotNullExpressionValue(kVar2, "guildRolesObservable");
        m.checkNotNullExpressionValue(kVar9, "mySelectedVoiceChannelVoiceStatesObservable");
        m.checkNotNullExpressionValue(kVar10, "currentChannelVoiceStatesObservable");
        Observable<StoreMediaSettings$VoiceConfiguration> voiceConfig8 = this.$storeMediaSettings.getVoiceConfig();
        m.checkNotNullExpressionValue(kVar3, "guildsObservable");
        m.checkNotNullExpressionValue(kVar4, "permissionsObservable");
        Observable<UserProfile> observableObserveUserProfile8 = this.$storeUserProfile.observeUserProfile(user.getId());
        Observable<Integer> observableObserve10 = this.$storeUserRelationships.observe(user.getId());
        Observable<StoreUserNotes$UserNoteState> observableObserveUserNote8 = this.$storeUserNotes.observeUserNote(user.getId());
        m.checkNotNullExpressionValue(kVar5, "userStageRolesObservable");
        m.checkNotNullExpressionValue(kVar6, "userStageRequestToSpeakStateObservable");
        m.checkNotNullExpressionValue(kVar7, "myStageRolesObservable");
        m.checkNotNullExpressionValue(kVar8, "canDisableCommunicationObservable");
        return ObservableCombineLatestOverloadsKt.combineLatest(observable, kVar2, kVar9, kVar10, voiceConfig8, observable2, kVar3, kVar4, forUser2, observableObserveUserProfile8, observableObserve10, observableObserveUserNote8, kVar5, kVar6, kVar7, kVar8, new WidgetUserSheetViewModelStoreState$observeStoreState$3$2(user, meUser2, channel, selectedVoiceChannel));
    }
}
