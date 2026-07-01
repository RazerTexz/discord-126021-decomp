package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ModelVoiceRegion implements Model {
    private boolean deprecated;
    private boolean hidden;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f2736id;
    private String name;
    private boolean optimal;
    private String sampleHostname;
    private int samplePort;

    @Override // com.discord.models.domain.Model
    public void assignField(Model.JsonReader jsonReader) throws IOException {
        String strNextName = jsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "deprecated":
                this.deprecated = jsonReader.nextBoolean(this.deprecated);
                break;
            case "optimal":
                this.optimal = jsonReader.nextBoolean(this.optimal);
                break;
            case "hidden":
                this.hidden = jsonReader.nextBoolean(this.hidden);
                break;
            case "id":
                this.f2736id = jsonReader.nextString(this.f2736id);
                break;
            case "name":
                this.name = jsonReader.nextString(this.name);
                break;
            case "sample_hostname":
                this.sampleHostname = jsonReader.nextString(this.sampleHostname);
                break;
            case "sample_port":
                this.samplePort = jsonReader.nextInt(this.samplePort);
                break;
            default:
                jsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelVoiceRegion;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelVoiceRegion)) {
            return false;
        }
        ModelVoiceRegion modelVoiceRegion = (ModelVoiceRegion) obj;
        if (!modelVoiceRegion.canEqual(this) || isOptimal() != modelVoiceRegion.isOptimal() || getSamplePort() != modelVoiceRegion.getSamplePort() || isDeprecated() != modelVoiceRegion.isDeprecated() || isHidden() != modelVoiceRegion.isHidden()) {
            return false;
        }
        String id2 = getId();
        String id3 = modelVoiceRegion.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
            return false;
        }
        String name = getName();
        String name2 = modelVoiceRegion.getName();
        if (name != null ? !name.equals(name2) : name2 != null) {
            return false;
        }
        String sampleHostname = getSampleHostname();
        String sampleHostname2 = modelVoiceRegion.getSampleHostname();
        return sampleHostname != null ? sampleHostname.equals(sampleHostname2) : sampleHostname2 == null;
    }

    public String getId() {
        return this.f2736id;
    }

    public String getName() {
        return this.name;
    }

    public String getSampleHostname() {
        return this.sampleHostname;
    }

    public int getSamplePort() {
        return this.samplePort;
    }

    public int hashCode() {
        int samplePort = (((getSamplePort() + (((isOptimal() ? 79 : 97) + 59) * 59)) * 59) + (isDeprecated() ? 79 : 97)) * 59;
        int i = isHidden() ? 79 : 97;
        String id2 = getId();
        int iHashCode = ((samplePort + i) * 59) + (id2 == null ? 43 : id2.hashCode());
        String name = getName();
        int iHashCode2 = (iHashCode * 59) + (name == null ? 43 : name.hashCode());
        String sampleHostname = getSampleHostname();
        return (iHashCode2 * 59) + (sampleHostname != null ? sampleHostname.hashCode() : 43);
    }

    public boolean isDeprecated() {
        return this.deprecated;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public boolean isOptimal() {
        return this.optimal;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelVoiceRegion(id=");
        sbU.append(getId());
        sbU.append(", name=");
        sbU.append(getName());
        sbU.append(", optimal=");
        sbU.append(isOptimal());
        sbU.append(", samplePort=");
        sbU.append(getSamplePort());
        sbU.append(", sampleHostname=");
        sbU.append(getSampleHostname());
        sbU.append(", deprecated=");
        sbU.append(isDeprecated());
        sbU.append(", hidden=");
        sbU.append(isHidden());
        sbU.append(")");
        return sbU.toString();
    }
}
