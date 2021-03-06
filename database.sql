USE [master]
GO
/****** Object:  Database [SWDCoffee]    Script Date: 4/4/2020 2:53:12 PM ******/
CREATE DATABASE [SWDCoffee]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'CSharpCoffee', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\SWDCoffee.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'CSharpCoffee_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\SWDCoffee_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [SWDCoffee] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [SWDCoffee].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [SWDCoffee] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [SWDCoffee] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [SWDCoffee] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [SWDCoffee] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [SWDCoffee] SET ARITHABORT OFF 
GO
ALTER DATABASE [SWDCoffee] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [SWDCoffee] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [SWDCoffee] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [SWDCoffee] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [SWDCoffee] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [SWDCoffee] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [SWDCoffee] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [SWDCoffee] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [SWDCoffee] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [SWDCoffee] SET  DISABLE_BROKER 
GO
ALTER DATABASE [SWDCoffee] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [SWDCoffee] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [SWDCoffee] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [SWDCoffee] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [SWDCoffee] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [SWDCoffee] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [SWDCoffee] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [SWDCoffee] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [SWDCoffee] SET  MULTI_USER 
GO
ALTER DATABASE [SWDCoffee] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [SWDCoffee] SET DB_CHAINING OFF 
GO
ALTER DATABASE [SWDCoffee] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [SWDCoffee] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [SWDCoffee] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [SWDCoffee] SET QUERY_STORE = OFF
GO
USE [SWDCoffee]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 4/4/2020 2:53:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[IsGuest] [bit] NOT NULL,
	[Birthday] [date] NULL,
	[Email] [nvarchar](100) NULL,
	[PhoneNumber] [nvarchar](100) NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cart]    Script Date: 4/4/2020 2:53:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart](
	[CartId] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](50) NULL,
	[TotalPrice] [float] NULL,
 CONSTRAINT [PK_Cart] PRIMARY KEY CLUSTERED 
(
	[CartId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CartProduct]    Script Date: 4/4/2020 2:53:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CartProduct](
	[CartId] [int] NULL,
	[CoffeeId] [int] NULL,
	[Quantity] [int] NULL,
	[Subtotal] [float] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Checkout]    Script Date: 4/4/2020 2:53:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Checkout](
	[CheckoutId] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](50) NULL,
	[CartId] [int] NULL,
	[DateCreated] [datetime] NULL,
 CONSTRAINT [PK_Checkout] PRIMARY KEY CLUSTERED 
(
	[CheckoutId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Coffee]    Script Date: 4/4/2020 2:53:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Coffee](
	[CoffeeId] [int] IDENTITY(1,1) NOT NULL,
	[CoffeeName] [nvarchar](50) NULL,
	[Price] [float] NULL,
	[Description] [nvarchar](500) NULL,
	[Ingredients] [nvarchar](100) NULL,
	[Origin] [nvarchar](100) NULL,
	[CoffeeImage] [nvarchar](max) NULL,
 CONSTRAINT [PK_Coffee] PRIMARY KEY CLUSTERED 
(
	[CoffeeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Coffee] ON 

INSERT [dbo].[Coffee] ([CoffeeId], [CoffeeName], [Price], [Description], [Ingredients], [Origin], [CoffeeImage]) VALUES (1, N'Americano', 39000, N'is a type of coffee drink prepared by diluting an espresso with hot water, giving it a similar strength to, but different flavor from, traditionally brewed coffee. The strength of an Americano varies with the number of shots of espresso and the amount of water added.', N'hot water and espresso', N'Espresso, America', N'https://firebasestorage.googleapis.com/v0/b/kalomacoffee.appspot.com/o/Americano.jpg?alt=media&token=50052ad8-1d6a-4f37-a9a7-fd6fbc95312f')
INSERT [dbo].[Coffee] ([CoffeeId], [CoffeeName], [Price], [Description], [Ingredients], [Origin], [CoffeeImage]) VALUES (2, N'Latte', 41000, N'Espresso made with steamed milk in a 1:3 to 1:5 ratio with a little foam.', N'espresso, steamed milk', N'Italy', N'https://firebasestorage.googleapis.com/v0/b/kalomacoffee.appspot.com/o/Latte.jpg?alt=media&token=db3fb580-4a4a-4b76-b010-c728a488029f')
INSERT [dbo].[Coffee] ([CoffeeId], [CoffeeName], [Price], [Description], [Ingredients], [Origin], [CoffeeImage]) VALUES (3, N'Cappuccino', 41000, N'Espresso made with hot milk and steamed milk foam.', N'coffee, cream, flavoring with cinnamon or chocolate powder.', N'Italy', N'https://firebasestorage.googleapis.com/v0/b/kalomacoffee.appspot.com/o/Cappuccino.jpg?alt=media&token=ef148f55-eb48-4f9b-abed-b81da75e815f')
INSERT [dbo].[Coffee] ([CoffeeId], [CoffeeName], [Price], [Description], [Ingredients], [Origin], [CoffeeImage]) VALUES (4, N'Espresso', 34000, N' A brew method and coffee that is ground and packed very fine. A small amount of water is added creating a different taste and strength of the coffee.', N'water, coffee beans', N'Italy', N'https://firebasestorage.googleapis.com/v0/b/kalomacoffee.appspot.com/o/Espresso.jpg?alt=media&token=34efcdc8-9435-42e4-bd72-ea9d51293739')
INSERT [dbo].[Coffee] ([CoffeeId], [CoffeeName], [Price], [Description], [Ingredients], [Origin], [CoffeeImage]) VALUES (5, N'Macchiato', 40000, N'An espresso made with a small amount of foamed milk, similar to a cappuccino only stronger.', N'espresso, milk', N'Italy', N'https://firebasestorage.googleapis.com/v0/b/kalomacoffee.appspot.com/o/Macchiato.jpg?alt=media&token=5484462a-f745-4f16-9f1d-273e58051c9b')
INSERT [dbo].[Coffee] ([CoffeeId], [CoffeeName], [Price], [Description], [Ingredients], [Origin], [CoffeeImage]) VALUES (6, N'Mocha', 45000, N'Sometimes called a cafe mocha, it is similar to a latte only chocolate syrup is added.', N'Chocolate, espresso, and hot milk', N'Mocha, Yemen', N'https://firebasestorage.googleapis.com/v0/b/kalomacoffee.appspot.com/o/Mocha.jpg?alt=media&token=2df60011-1bbb-49fe-b630-d344f6357c41')
INSERT [dbo].[Coffee] ([CoffeeId], [CoffeeName], [Price], [Description], [Ingredients], [Origin], [CoffeeImage]) VALUES (7, N'Black Coffee', 20000, N'Coffee served straight from the carafe after brewing without adding anything to it to alter the flavor', N'coffee, water', N'Variety', N'https://firebasestorage.googleapis.com/v0/b/kalomacoffee.appspot.com/o/BlackCoffee.jpg?alt=media&token=314978ab-93aa-463d-b925-20074b229939')
INSERT [dbo].[Coffee] ([CoffeeId], [CoffeeName], [Price], [Description], [Ingredients], [Origin], [CoffeeImage]) VALUES (8, N'Iced Milk Coffee', 23000, N'It is made by mixing black coffee with a quarter to a half as much sweetened condensed milk and poured over ice.', N'coffee, milk, water', N'Variety', N'https://firebasestorage.googleapis.com/v0/b/kalomacoffee.appspot.com/o/IcedMilkCoffee.jpg?alt=media&token=f40c9955-0001-4ea7-b48b-607c52f33b34')
INSERT [dbo].[Coffee] ([CoffeeId], [CoffeeName], [Price], [Description], [Ingredients], [Origin], [CoffeeImage]) VALUES (9, N'Coffee Beans', 20000, N'Seeds of different types of coffee', N'beans', N'Variety', N'https://firebasestorage.googleapis.com/v0/b/kalomacoffee.appspot.com/o/CoffeeBeans.jpg?alt=media&token=0e0e3c7b-ae11-40ae-83a6-f11ebd6db78e')
INSERT [dbo].[Coffee] ([CoffeeId], [CoffeeName], [Price], [Description], [Ingredients], [Origin], [CoffeeImage]) VALUES (10, N'Coffee Powder', 20000, N'Powder of different types of coffee', N'powder', N'Variety', N'https://firebasestorage.googleapis.com/v0/b/kalomacoffee.appspot.com/o/CoffeePowder.jpg?alt=media&token=bbad5879-088a-42fa-92fe-7b79325170b9')
SET IDENTITY_INSERT [dbo].[Coffee] OFF
SET ANSI_PADDING ON
GO
/****** Object:  Index [UK_UserEmail]    Script Date: 4/4/2020 2:53:14 PM ******/
ALTER TABLE [dbo].[Account] ADD  CONSTRAINT [UK_UserEmail] UNIQUE NONCLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD  CONSTRAINT [FK_Cart_Account] FOREIGN KEY([Username])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[Cart] CHECK CONSTRAINT [FK_Cart_Account]
GO
ALTER TABLE [dbo].[CartProduct]  WITH CHECK ADD  CONSTRAINT [FK_CartProduct_Cart] FOREIGN KEY([CartId])
REFERENCES [dbo].[Cart] ([CartId])
GO
ALTER TABLE [dbo].[CartProduct] CHECK CONSTRAINT [FK_CartProduct_Cart]
GO
ALTER TABLE [dbo].[CartProduct]  WITH CHECK ADD  CONSTRAINT [FK_CartProduct_Coffee] FOREIGN KEY([CoffeeId])
REFERENCES [dbo].[Coffee] ([CoffeeId])
GO
ALTER TABLE [dbo].[CartProduct] CHECK CONSTRAINT [FK_CartProduct_Coffee]
GO
ALTER TABLE [dbo].[Checkout]  WITH CHECK ADD  CONSTRAINT [FK_Checkout_Account] FOREIGN KEY([Username])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[Checkout] CHECK CONSTRAINT [FK_Checkout_Account]
GO
ALTER TABLE [dbo].[Checkout]  WITH CHECK ADD  CONSTRAINT [FK_Checkout_Cart] FOREIGN KEY([CartId])
REFERENCES [dbo].[Cart] ([CartId])
GO
ALTER TABLE [dbo].[Checkout] CHECK CONSTRAINT [FK_Checkout_Cart]
GO
USE [master]
GO
ALTER DATABASE [SWDCoffee] SET  READ_WRITE 
GO
