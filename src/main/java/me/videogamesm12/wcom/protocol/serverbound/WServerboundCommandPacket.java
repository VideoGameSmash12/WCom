package me.videogamesm12.wcom.protocol.serverbound;

import lombok.Getter;
import me.videogamesm12.wcom.WPacket;

@Getter
@WPacket.PacketMeta(id = {"wcom", "serverbound/command"},
        direction = WPacket.PacketMeta.Direction.SERVER_BOUND)
public class WServerboundCommandPacket extends WPacket
{
    private final String message;

    public WServerboundCommandPacket(final long transactionId, final String message)
    {
        super(transactionId);
        this.message = message;
    }
}
