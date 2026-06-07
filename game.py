import random

choices = ['stone', 'paper', 'scissor']

def winner(p, c):
    if p == c:
        return 0
    if (p == 'stone' and c == 'scissor') or (p == 'paper' and c == 'stone') or (p == 'scissor' and c == 'paper'):
        return 1
    return -1

def get_player_choice():
    while True:
        ch = input("Enter your choice (stone/paper/scissor): ").strip().lower()
        if ch in choices:
            return ch
        print("Invalid choice. Try again.")

def play_part(part_no):
    part_points_player = 0
    part_points_comp = 0
    print(f"\nStarting Part {part_no} (5 rounds)")
    for r in range(1,6):
        print(f"Round {r} of Part {part_no}")
        p = get_player_choice()
        c = random.choice(choices)
        print(f"Computer chose: {c}")
        res = winner(p,c)
        if res == 1:
            part_points_player += 1
            print("You win this round.")
        elif res == -1:
            part_points_comp += 1
            print("Computer wins this round.")
        else:
            print("This round is a tie.")
        print(f"Score this part - You: {part_points_player}, Computer: {part_points_comp}\n")
    return part_points_player, part_points_comp

def main():
    print("Stone Paper Scissor - 2 parts, 5 rounds each (total 10 rounds)")
    p1, c1 = play_part(1)
    p2, c2 = play_part(2)
    total_player = p1 + p2
    total_comp = c1 + c2
    print("Final Results:")
    print(f"Part 1 - You: {p1}, Computer: {c1}")
    print(f"Part 2 - You: {p2}, Computer: {c2}")
    print(f"Total - You: {total_player}, Computer: {total_comp}")
    if total_player > total_comp:
        print("You are the overall winner!")
    elif total_comp > total_player:
        print("Computer is the overall winner.")
    else:
        print("Overall result is a tie.")

if __name__ == '__main__':
    main()
