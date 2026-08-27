package me.videogamesm12.wcom.protocol.clientbound;

import lombok.Getter;
import me.videogamesm12.wcom.Stage;
import me.videogamesm12.wcom.WPacket;
import net.kyori.adventure.nbt.CompoundBinaryTag;
import net.kyori.adventure.nbt.TagStringIO;

import java.io.IOException;

@Getter
@WPacket.PacketMeta(id = {"wnet", "clientbound/configure_acknowledge"},
        direction = WPacket.PacketMeta.Direction.CLIENT_BOUND,
        stage = Stage.CONFIGURATION)
public class WClientboundConfigureAcknowledgePacket extends WPacket
{
    private final CompoundBinaryTag demands;

    public WClientboundConfigureAcknowledgePacket(long transactionId, String demands)
    {
        super(transactionId);

        CompoundBinaryTag deserializedDemands;
        try
        {
            deserializedDemands = TagStringIO.get().asCompound(demands);
        }
        catch (IOException ex)
        {
            // probably more possible, so we'll just make it blank
            deserializedDemands = CompoundBinaryTag.empty();
        }

        this.demands = deserializedDemands;
    }

    public String formatDemands()
    {
        try
        {
            return TagStringIO.get().asString(demands);
        }
        catch (IOException ex)
        {
            // probably impossible
            return "{}";
        }
    }
}
