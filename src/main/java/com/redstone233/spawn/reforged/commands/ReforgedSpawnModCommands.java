package com.redstone233.spawn.reforged.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.redstone233.spawn.reforged.ModGlobalInfo;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.ServerTickManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import static net.minecraft.server.command.CommandManager.literal;
import static net.minecraft.server.command.CommandManager.argument;

public class ReforgedSpawnModCommands {

    public static String[] typeArray = { "trifunc", "deffunc" };
    public static String[] nameArray = { "sin", "cos", "tan", "asin", "acos", "atan" };
    public static String[] infoArray = { "abs", "sqrt", "cbrt", "ceil", "floor", "round" };

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("trsm")
            .requires(c -> c.hasPermissionLevel(4))
            .then(literal("info")
                    .then(argument("page", IntegerArgumentType.integer(1, 4))
                        .executes(
                            run -> getSuccess(run.getSource(), IntegerArgumentType.getInteger(run, "page")))))
                .requires(b -> b.hasPermissionLevel(4))
                .then(literal("depends")
                .executes(a -> executeStopStep(a.getSource()))
                    .then(literal("fabric")
                    .executes(a -> getDependsFabric(a.getSource()))
                )
                    .then(literal("minecraft")
                    .executes(d -> getDependsMinecraft(d.getSource()))
                )
            )                 
        );

        dispatcher.register(literal("long")
            .requires(src -> src.hasPermissionLevel(2))
            .then(argument("value", IntegerArgumentType.integer())
                .executes(run -> getValue(IntegerArgumentType.getInteger(run, "value"), 
                run.getSource().getPlayer(),run)
                )
            )
        );

        dispatcher.register(literal("reforged")
            .requires(sec -> sec.hasPermissionLevel(4))
            .then(literal("nbt")
                .executes(a -> executeStopStep(a.getSource()))
                .then(argument("slot", IntegerArgumentType.integer())
                    .executes(b -> getSuccess(b.getSource(), IntegerArgumentType.getInteger(b, "slot"), 
                    b.getSource().getPlayer())
                    )
                )
            )
            .then(literal("math")
                .executes(a -> executeStopStep(a.getSource()))
                .then(literal(typeArray[0])
                    .executes(b -> executeStopStep(b.getSource()))
                    .then(literal(nameArray[0])
                        .executes(c -> executeStopStep(c.getSource()))
                        .then(argument("angle", DoubleArgumentType.doubleArg())
                            .executes(d -> mathTrig(d.getSource(), 
                    DoubleArgumentType.getDouble(d, "angle"),nameArray[0])
                            )
                        )
                    )
                    .then(literal(nameArray[1])
                        .executes(c -> executeStopStep(c.getSource()))
                        .then(argument("angle", DoubleArgumentType.doubleArg())
                            .executes(d -> mathTrig(d.getSource(), 
                    DoubleArgumentType.getDouble(d, "angle"),nameArray[1])
                            )
                        )
                    )
                    .then(literal(nameArray[2])
                        .executes(c -> executeStopStep(c.getSource()))
                        .then(argument("angle", DoubleArgumentType.doubleArg())
                            .executes(d -> mathTrig(d.getSource(), 
                    DoubleArgumentType.getDouble(d, "angle"),nameArray[2])
                            )
                        )
                    )
                    .then(literal(nameArray[3])
                        .executes(c -> executeStopStep(c.getSource()))
                        .then(argument("angle", DoubleArgumentType.doubleArg())
                            .executes(d -> mathTrig(d.getSource(), 
                    DoubleArgumentType.getDouble(d, "angle"),nameArray[3])
                            )
                        )
                    )
                    .then(literal(nameArray[4])
                        .executes(c -> executeStopStep(c.getSource()))
                        .then(argument("angle", DoubleArgumentType.doubleArg())
                            .executes(d -> mathTrig(d.getSource(), 
                    DoubleArgumentType.getDouble(d, "angle"),nameArray[4])
                            )
                        )
                    )
                    .then(literal(nameArray[5])
                        .executes(c -> executeStopStep(c.getSource()))
                        .then(argument("angle", DoubleArgumentType.doubleArg())
                            .executes(d -> mathTrig(d.getSource(), 
                    DoubleArgumentType.getDouble(d, "angle"),nameArray[5])
                            )
                        )
                    )
                )
                .requires(src -> src.hasPermissionLevel(4))
                .then(literal(typeArray[1])
                    .executes(a -> executeStopStep(a.getSource()))
                    .then(literal(infoArray[0])
                        .executes(b -> executeStopStep(b.getSource()))
                        .then(argument("value", DoubleArgumentType.doubleArg())
                            .executes(c -> mathDefe(c.getSource(), 
                        DoubleArgumentType.getDouble(c, "value"), infoArray[0])
                            )
                        )
                    )
                    .then(literal(infoArray[1])
                        .executes(b -> executeStopStep(b.getSource()))
                        .then(argument("value", DoubleArgumentType.doubleArg())
                            .executes(c -> mathDefe(c.getSource(),
                         DoubleArgumentType.getDouble(c, "value"), infoArray[1])
                            )
                        )
                    )
                    .then(literal(infoArray[2])
                        .executes(b -> executeStopStep(b.getSource()))
                        .then(argument("value", DoubleArgumentType.doubleArg())
                            .executes(c -> mathDefe(c.getSource(), 
                        DoubleArgumentType.getDouble(c, "value"), infoArray[2])
                            )
                        )
                    )
                    .then(literal(infoArray[3])
                        .executes(b -> executeStopStep(b.getSource()))
                        .then(argument("value", DoubleArgumentType.doubleArg())
                            .executes(c -> mathDefe(c.getSource(), 
                        DoubleArgumentType.getDouble(c, "value"), infoArray[3])
                            )
                        )
                    )
                    .then(literal(infoArray[4])
                        .executes(b -> executeStopStep(b.getSource()))
                        .then(argument("value", DoubleArgumentType.doubleArg())
                            .executes(c -> mathDefe(c.getSource(), 
                        DoubleArgumentType.getDouble(c, "value"), infoArray[4])
                            )
                        )
                    )
                    .then(literal(infoArray[5])
                        .executes(b -> executeStopStep(b.getSource()))
                        .then(argument("value", DoubleArgumentType.doubleArg())
                            .executes(c -> mathDefe(c.getSource(), 
                        DoubleArgumentType.getDouble(c, "value"), infoArray[5])
                            )
                        )
                    )
                )
            )
        );
    }

    private static int mathTrig(ServerCommandSource source,double angle,String name) {
        PlayerEntity player = source.getPlayer();
        double value = Math.toRadians(angle);
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            source.sendFeedback(() -> {
               if (angle == value) {
                if (name == nameArray[0]) {
                    player.sendMessage((Text) new LiteralMessage("Angle" + angle + "sine is" + Math.sin(value)), false);
                }
                if (name == nameArray[1]) {
                    player.sendMessage((Text) new LiteralMessage("Angle" + angle + "cosine is" + Math.cos(value)), false);
                }
                if (name == nameArray[2]) {
                    player.sendMessage((Text) new LiteralMessage("Angle" + angle + "tangent is" + Math.tan(value)), false);
                }
                if (name == nameArray[3]) {
                    player.sendMessage((Text) new LiteralMessage("Angle" + angle + "arcsine is" + Math.asin(value)), false);
                }
                if (name == nameArray[4]) {
                    player.sendMessage((Text) new LiteralMessage("Angle" + angle + "arccosine is" + Math.acos(value)),
                        false);
                }
                if (name == nameArray[5]) {
                    player.sendMessage((Text) new LiteralMessage("Angle" + angle + "arctangent is" + Math.atan(value)),
                        false);
                }
               }
               return Text.translatable("commands.trsm.info.depends.success");
            }, true);
            return 1;
         } else {
            source.sendError(Text.translatable("commands.trsm.info.depends.fail"));
            return 0;
         }
    }

    private static int mathDefe(ServerCommandSource source,double value,String name) {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            source.sendFeedback(() -> {
                if (name == infoArray[0]) {
                    player.sendMessage((Text) new LiteralMessage("Value" + value + "absolute value is" + Math.abs(value)),
                        false);
                }
                if (name == infoArray[1]) {
                    player.sendMessage((Text) new LiteralMessage("Value" + value + "square root is" + Math.sqrt(value)),
                        false);
                }
                if (name == infoArray[2]) {
                    player.sendMessage((Text) new LiteralMessage("Value" + value + "cube root is" + Math.cbrt(value)),
                        false);
                }
                if (name == infoArray[3]) {
                    player.sendMessage((Text) new LiteralMessage("Value" + value + "round up is" + Math.ceil(value)),
                        false);
                }
                if (name == infoArray[4]) {
                    player.sendMessage((Text) new LiteralMessage("Value" + value + "round down is" + Math.floor(value)),
                        false);
                }
                if (name == infoArray[5]) {
                    player.sendMessage(
                        (Text) new LiteralMessage("Value" + value + "nearest integer is" + Math.round(value)), false);
                }
               return Text.translatable("commands.reforged.success");
            }, true);
            return 1;
         } else {
            source.sendError(Text.translatable("commands.reforged.fail"));
            return 0;
         }
    }

    private static int getDependsFabric(ServerCommandSource source) {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
           source.sendFeedback(() -> {
                player.sendMessage((Text) new LiteralMessage("[Cmds/INFO]Dependence Fabric to" + ModGlobalInfo.TextGlobal.versionAr[1]));
                return Text.translatable("commands.info.depends.fabric.success");
           }, true);
           return 1;
        } else {
           source.sendError(Text.translatable("commands.info.depends.fabric.fail"));
           return 0;
        }
    }

    private static int getValue(int value,PlayerEntity player, CommandContext<ServerCommandSource> source) {
        if (value %2 == 0) {
            source.getSource().sendFeedback(() -> {
                return Text.translatable("commands.int.value.even.success");
            }, true);
            return value;
        } else if (value %2 != 0) {
            source.getSource().sendError(Text.translatable("commands.int.value.odd.success"));
            return value;
        } else {
            source.getSource().sendError(Text.translatable("commands.long.value.fail"));
            return 0;
        }
    }

    private static int getDependsMinecraft(ServerCommandSource source) {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
           source.sendFeedback(() -> {
              player.sendMessage((Text) new LiteralMessage("[Cmds/INFO]Dependence Minecraft to" + ModGlobalInfo.TextGlobal.versionAr[0]));
              return Text.translatable("commands.info.depends.minecraft.success");
           }, true);
           return 1;
        } else {
           source.sendError(Text.translatable("commands.info.depends.minecraft.fail"));
           return 0;
        }
    }

    private static int getSuccess(ServerCommandSource source, int page) {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            source.sendFeedback(() -> {
                if (page == 1) {
                    player.sendMessage((Text) new LiteralMessage("[Cmds/Main]" + ModGlobalInfo.TextGlobal.textArray[0]),false);
                } else if (page == 2) {
                    player.sendMessage((Text) new LiteralMessage("[Cmds/Main]" + ModGlobalInfo.TextGlobal.textArray[1]),false);
                } else if (page == 3) {
                    player.sendMessage((Text) new LiteralMessage("[Cmds/Main]" + ModGlobalInfo.TextGlobal.textArray[2]),false);
                } else if (page == 4) {
                    player.sendMessage((Text) new LiteralMessage("[Cmds/Main]" + ModGlobalInfo.TextGlobal.textArray[3]),false);
                }
                return Text.translatable("commands.trsm.info.page.success");
            }, true);
            return page;
        } else {
            if (page <= 0) {
                player.sendMessage((Text) new LiteralMessage("[Cmds/ERROR]This value is so small!"),false);
            }
            if (page >= 5) {
                player.sendMessage((Text) new LiteralMessage("[Cmds/ERROR]This value is so big!"),false);
            }
            source.sendError(Text.translatable("commands.trsm.info.page.fail"));
            return page;
        }
    }

    private static int executeStopStep(ServerCommandSource source) {
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
           source.sendFeedback(() -> {
              return Text.translatable("commands.reforged.success");
           }, true);
           return 1;
        } else {
           source.sendError(Text.translatable("commands.reforged.fail"));
           return 0;
        }
     }

     public static int getSuccess(ServerCommandSource source, int slot, PlayerEntity player) {
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        ItemStack stack = player.getInventory().getStack(slot);
        if (bl) {
            if (slot >= 0 && slot <= 40) {
                if (stack.hasNbt()) {
                    assert stack.getNbt() != null;
                    String s = stack.getNbt().toString();
                    player.sendMessage((Text) new LiteralMessage(s),false);
                } else {
                    player.sendMessage((Text) new LiteralMessage("This item has no NBT!"),false);
                }
            } else if (slot < 0) {
                player.sendMessage((Text) new LiteralMessage("This value you entered is too small!"), false);
            } else if (slot > 40) {
                player.sendMessage((Text) new LiteralMessage("This value you entered is too large!"), false);
            }
        source.sendFeedback(() -> {
            return Text.translatable("commands.reforged.success");
         }, true);
         return 1;
    } else {
        source.sendError(Text.translatable("commands.reforged.fail"));
           return 0;
        }
    }
}

