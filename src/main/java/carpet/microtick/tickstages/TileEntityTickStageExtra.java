package carpet.microtick.tickstages;

import carpet.microtick.MicroTickUtil;
import carpet.utils.Messenger;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;

public class TileEntityTickStageExtra implements TickStage
{
	private final BlockPos pos;
	private final Block block;
	private final int order;

	public TileEntityTickStageExtra(TileEntity tileEntity, int order)
	{
		this.pos = tileEntity.getPos().toImmutable();
		this.block = tileEntity.getBlockState().getBlock();
		this.order = order;
	}

	@Override
	public ITextComponent toText()
	{
		return Messenger.c(
				"w Block: ",
				MicroTickUtil.getTranslatedName(this.block),
				String.format("w \nOrder: %d", this.order),
				String.format("w \nPosition: [%d, %d, %d]", this.pos.getX(), this.pos.getY(), this.pos.getZ())
		);
	}
}